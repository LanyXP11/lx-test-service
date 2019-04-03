package com.lx.service;

import com.lx.pk.client.result.BaseResult;
import com.lx.service.post.KafkaSendMessagesPost;

/**
 * Created by chenjiang on 2018/12/19.
 */
public interface KafkaService {
    /**
     * 使用Kafka发送消息
     * @param KafkaSendMessagesPost
     * @return
     */
    public BaseResult<Boolean> sendMessage(KafkaSendMessagesPost KafkaSendMessagesPost);
}
