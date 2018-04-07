package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallStorage;
import org.linlinjava.litemall.db.domain.LitemallStorageExample;

public interface LitemallStorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    long countByExample(LitemallStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByExample(LitemallStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insert(LitemallStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insertSelective(LitemallStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    List<LitemallStorage> selectByExample(LitemallStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallStorage> selectByExampleSelective(@Param("example") LitemallStorageExample example, @Param("selective") LitemallStorage.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    LitemallStorage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallStorage selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallStorage.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") LitemallStorage record, @Param("example") LitemallStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExample(@Param("record") LitemallStorage record, @Param("example") LitemallStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKeySelective(LitemallStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKey(LitemallStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallStorage selectOneByExample(LitemallStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallStorage selectOneByExampleSelective(@Param("example") LitemallStorageExample example, @Param("selective") LitemallStorage.Column ... selective);
}