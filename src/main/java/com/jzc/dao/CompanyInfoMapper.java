package com.jzc.dao;

import com.jzc.domain.CompanyInfo;
import com.jzc.domain.CompanyInfoWithBLOBs;

public interface CompanyInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    int insert(CompanyInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    int insertSelective(CompanyInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    CompanyInfoWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    int updateByPrimaryKeySelective(CompanyInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(CompanyInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table companyinfo
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    int updateByPrimaryKey(CompanyInfo record);
}