package org.linlinjava.litemall.wx.web;

import org.apache.commons.lang3.StringUtils;
import org.linlinjava.litemall.core.util.RegexUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallFeedback;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.LitemallFeedbackService;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

/**
 * @author Yogeek
 * @date 2018/8/25 14:10
 */
@RestController
@RequestMapping("/wx/feedback")
@Validated
public class WxFeedbackController {
    private final Log logger = LogFactory.getLog(WxFeedbackController.class);

    @Autowired
    private LitemallFeedbackService feedbackService;
    @Autowired
    private LitemallUserService userService;

    private Object validate(LitemallFeedback feedback) {
        String content = feedback.getContent();
        if(StringUtils.isEmpty(content)){
            return ResponseUtil.badArgument();
        }

        String type = feedback.getFeedType();
        if(StringUtils.isEmpty(type)){
            return ResponseUtil.badArgument();
        }

        // 测试手机号码是否正确
        String mobile = feedback.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return ResponseUtil.badArgument();
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    /**
     *  意见反馈
     */
    @PostMapping("submit")
    public Object submit(@LoginUser Integer userId, @RequestBody LitemallFeedback feedback) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Object error = validate(feedback);
        if(error != null){
            return error;
        }

        LitemallUser user = userService.findById(userId);
        String username = user.getUsername();
        feedback.setId(null);
        feedback.setUserId(userId);
        feedback.setUsername(username);
        feedback.setAddTime(LocalDateTime.now());
        //状态默认是0，1表示状态已发生变化
        feedback.setStatus(1);
        feedbackService.add(feedback);

        return ResponseUtil.ok();
    }

}
