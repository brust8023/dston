package org.linlinjava.litemall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.core.storage.StorageService;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.LitemallStorage;
import org.linlinjava.litemall.db.service.LitemallStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/storage")
@Validated
public class AdminStorageController {
    private final Log logger = LogFactory.getLog(AdminStorageController.class);

    @Autowired
    private StorageService storageService;
    @Autowired
    private LitemallStorageService litemallStorageService;

    @RequiresPermissions("admin:storage:list")
    @GetMapping("/list")
    public Object list(String key, String name,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallStorage> storageList = litemallStorageService.querySelective(key, name, page, limit, sort, order);
        int total = litemallStorageService.countSelective(key, name, page, limit, sort, order);
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", storageList);

        return ResponseUtil.ok(data);
    }

    @RequiresPermissions("admin:storage:create")
    @PostMapping("/create")
    public Object create(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String url = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return ResponseUtil.ok(data);
    }

    @RequiresPermissions("admin:storage:read")
    @PostMapping("/read")
    public Object read(@NotNull Integer id) {
        LitemallStorage storageInfo = litemallStorageService.findById(id);
        if (storageInfo == null) {
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok(storageInfo);
    }

    @RequiresPermissions("admin:storage:delete")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallStorage litemallStorage) {
        if (litemallStorageService.update(litemallStorage) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(litemallStorage);
    }

    @RequiresPermissions("admin:storage:delete")
    @PostMapping("/delete")
    public Object delete(@RequestBody LitemallStorage litemallStorage) {
        String key = litemallStorage.getKey();
        if (StringUtils.isEmpty(key)) {
            return ResponseUtil.badArgument();
        }
        litemallStorageService.deleteByKey(key);
        storageService.delete(key);
        return ResponseUtil.ok();
    }
}
