package com.wedaa.notes.notification.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RabbitMessageModel {

    private static Long lastAssignedId = 0L;

    private Long id;
    private String message;
    private Date dateTime;

    public RabbitMessageModel() {
        this.id = ++lastAssignedId;
        this.dateTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        return "Message{" + "id=" + getId() + ", message=" + getMessage() + ", dateTime=" + formatter.format(getDateTime()) + "}";
    }
}
