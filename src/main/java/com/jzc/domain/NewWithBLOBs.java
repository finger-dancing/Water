package com.jzc.domain;

public class NewWithBLOBs extends New {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.content
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.picture
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    private String picture;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.content
     *
     * @return the value of news.content
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.content
     *
     * @param content the value for news.content
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.picture
     *
     * @return the value of news.picture
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.picture
     *
     * @param picture the value for news.picture
     *
     * @mbggenerated Thu Jun 30 15:30:09 CST 2016
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}