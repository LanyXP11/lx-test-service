package com.lx.service.post;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by chenjiang on 2018/12/19.
 */

public class KafkaSendMessagesPost implements Serializable {

    @NotNull(message = "topic主题不允许为空")
    private String topic;

    @NotNull(message = "key值不允许为空")
    private String key;
    @NotNull(message = "消息不允许为空")
    private String data;

    private String ifPartition;

    private Integer partitionNum;

    private String role;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIfPartition() {
        return ifPartition;
    }

    public void setIfPartition(String ifPartition) {
        this.ifPartition = ifPartition;
    }

    public Integer getPartitionNum() {
        return partitionNum;
    }

    public void setPartitionNum(Integer partitionNum) {
        this.partitionNum = partitionNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
