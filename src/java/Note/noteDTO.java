/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package note;

import java.util.Date;

/**
 *
 * @author Walking Bag
 */
public class noteDTO {

    private long id;
    private long userid;
    private String title;
    private String noteInfo;
    private String content;
    private Date timestamp;

    public noteDTO() {
    }

    public noteDTO(long id, long userid, String title, String noteInfo, String content, Date timestamp) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.noteInfo = noteInfo;
        this.content = content;
        this.timestamp = timestamp;
    }

    //Note view
    public noteDTO(long userid, String title, String noteInfo) {
        this.userid = userid;
        this.title = title;
        this.noteInfo = noteInfo;
    }

    //Note load
    public noteDTO(long id, long userid, String title, String content) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.content = content;
    }

    //Note load for saving
    public noteDTO(long id, String title, String noteInfo, String content) {
        this.id = id;
        this.title = title;
        this.noteInfo = noteInfo;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteInfo() {
        return noteInfo;
    }

    public void setNoteInfo(String noteInfo) {
        this.noteInfo = noteInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
