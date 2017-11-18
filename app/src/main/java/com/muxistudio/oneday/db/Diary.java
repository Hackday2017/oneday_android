package com.muxistudio.oneday.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by fengminchao on 17/11/18
 */

@Entity
public class Diary {

    @Id
    private Long id;
    private String title;
    /**
     * tag id
     */
    private int tag;
    /**
     * timestamp
     */
    private long time;
    /**
     * rate 0 - 100
     */
    private int rate;
    /**
     * 所问问题的id列表json字符串
     */
    private String questions;
    /**
     * 所问问题的回答列表json字符串
     */
    private String answers;
    @Generated(hash = 117076861)
    public Diary(Long id, String title, int tag, long time, int rate,
            String questions, String answers) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.time = time;
        this.rate = rate;
        this.questions = questions;
        this.answers = answers;
    }
    @Generated(hash = 112123061)
    public Diary() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getTag() {
        return this.tag;
    }
    public void setTag(int tag) {
        this.tag = tag;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public int getRate() {
        return this.rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public String getQuestions() {
        return this.questions;
    }
    public void setQuestions(String questions) {
        this.questions = questions;
    }
    public String getAnswers() {
        return this.answers;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
