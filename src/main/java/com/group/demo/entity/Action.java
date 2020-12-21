package com.group.demo.entity;

import java.time.LocalDateTime;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/24
 * @description
 */
public class Action {
    private Integer id;
    private String name;
    private Double point;
    private User actionUser;
    private Thing thing;
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public User getActionUser() {
        return actionUser;
    }

    public void setActionUser(User actionUser) {
        this.actionUser = actionUser;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", actionUser=" + actionUser +
                ", thing=" + thing +
                ", createTime=" + createTime +
                '}';
    }
}
