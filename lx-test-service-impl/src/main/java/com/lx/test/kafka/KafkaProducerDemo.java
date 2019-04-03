//package com.lx.test.kafka;
//
//import com.alibaba.fastjson.JSON;
//import com.lx.test.service.KafkaServiceImpl;KafkaServiceImpl
//import org.apache.commons.logging.Log;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.support.ProducerListener;
//import org.springframework.stereotype.Component;
//
///**
// * Created by chenjiang on 2018/12/19.
// * <p>
// * 这是一个简单的Kafka消息监听器参考网上
// * https://www.cnblogs.com/wangb0402/p/6187796.html
// * </p>
// */
//
//public class KafkaProducerDemo implements ProducerListener {
//
//    private Logger LOG = LoggerFactory.getLogger(KafkaProducerDemo.class);
//
//    /**
//     * 用户发送kafka消息成功后调用
//     *
//     * @param topic
//     * @param partition
//     * @param key
//     * @param value
//     * @param recordMetadata
//     */
//    @Override
//    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
//        LOG.info("==========kafka发送数据成功（日志开始）==========");
//        LOG.info("----------topic:" + topic);
//        LOG.info("----------partition:" + partition);
//        LOG.info("----------key:" + key);
//        LOG.info("----------value:" + value);
//        LOG.info("----------RecordMetadata:" + recordMetadata);
//        LOG.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
//    }
//
//    /**
//     * @param topic
//     * @param partition
//     * @param key
//     * @param value
//     * @param exception
//     */
//    @Override
//    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
//        LOG.info("==========kafka发送数据错误（日志开始）==========");
//        LOG.info("----------topic:" + topic);
//        LOG.info("----------partition:" + partition);
//        LOG.info("----------key:" + key);
//        LOG.info("----------value:" + value);
//        LOG.info("----------Exception:" + exception);
//        LOG.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
//        LOG.info("Exceptiong Info:[{}]", JSON.toJSONString(exception));
//    }
//
//    /**
//     * messages
//     *
//     * @return
//     */
//    @Override
//    public boolean isInterestedInSuccess() {
//        return true;
//    }
//}
