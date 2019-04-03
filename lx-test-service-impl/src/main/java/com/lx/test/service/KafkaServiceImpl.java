//package com.lx.test.service;
//
//import com.alibaba.fastjson.JSON;
//import com.lx.pk.client.result.BaseResult;
//import com.lx.pk.core.constant.ErrorCodeEnum;
//import com.lx.pk.core.exception.DubboServiceException;
//import com.lx.pk.dubbo.DubboService;
//import com.lx.pk.utils.AssertCommonUtil;
//import com.lx.service.KafkaService;
//import com.lx.service.post.KafkaSendMessagesPost;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFuture;
//
//import javax.annotation.Resource;
//import java.util.Random;
//import java.util.concurrent.ExecutionException;
//
//
///**
// * Created by chenjiang on 2018/12/19.
// * <p>
// * 这是一个简单的使用Kafka发送消息模板的方法支持两种发送消息发送方式
// * 一用户可以指定分区和用户不用指定分区的方式,
// * <p>
// * 代码部分来自网络上待测试
// */
//@DubboService
//@SuppressWarnings("all")
//public class KafkaServiceImpl implements KafkaService {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    private static Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);
//
//    /**
//     * Kafka发送消息
//     *
//     * @param KafkaSendMessagesPost
//     * @return
//     */
//    @Override
//    public BaseResult<Boolean> sendMessage(KafkaSendMessagesPost post) {
//        BaseResult<Boolean> result = new BaseResult<>();
//        logger.info("调用发送kafk消息服务参数是:topic:{},key:{},data:{},ifPartition:{},partitionNum:{}", post.getTopic(),post.getKey(), post.getData(), post.getIfPartition(), post.getPartitionNum());
//        try {
//
//            String topic = post.getTopic();
//            String data = post.getData();
//            String key = post.getKey();
//            String ifPartition = post.getIfPartition();
//
//            AssertCommonUtil.notNull(topic, "消息主题不允许为空");
//            AssertCommonUtil.notNull(data, "消息不允许为空");
//            AssertCommonUtil.notNull(key, "消息key值不允许为空");
//
//            if (StringUtils.isNotBlank(ifPartition) || ifPartition.equals("0")) {
//                int partitionIndex = this.getPartitionIndex(key, post.getPartitionNum());
//                ListenableFuture<SendResult<String, String>> sendResult = this.kafkaTemplate.send(topic, partitionIndex, data, key);
//                result = this.checkProRecord(sendResult);
//            } else {
//                ListenableFuture<SendResult<String, String>> sendResult = this.kafkaTemplate.send(topic, key, data);
//                result = this.checkProRecord(sendResult);
//            }
//
//        } catch (DubboServiceException de) {
//            logger.info("Kafka SendMessages Fail DubboServiceException:{}", JSON.toJSONString(de));
//            result.setCode(de.getCode());
//            result.setMessage(de.getMessage());
//        } catch (Exception e) {
//            logger.error("Kafka SendMessages Fail SystemError:{}", JSON.toJSONString(e));
//            result.setCode(ErrorCodeEnum.SYSTEM_ERROR.getCode());
//            result.setMessage(ErrorCodeEnum.SYSTEM_ERROR.getMessage());
//        }
//        return result;
//    }
//
//
//    /**
//     * 获取分区索引
//     *
//     * @param key
//     * @param partitionNum
//     * @return
//     */
//    private int getPartitionIndex(String key, int partitionNum) {
//        if (key == null) {
//            Random random = new Random();
//            return random.nextInt(partitionNum);
//        } else {
//            int result = Math.abs(key.hashCode()) % partitionNum;
//            return result;
//        }
//    }
//
//    /**
//     * 检查结果
//     *
//     * @param res
//     * @return
//     */
//    private BaseResult<Boolean> checkProRecord(ListenableFuture<SendResult<String, String>> res) {
//        BaseResult<Boolean> baseResult = new BaseResult<>();
//        if (res != null) {
//            try {
//
//                SendResult<String, String> sendResult = res.get();
//
//                final Long offset = sendResult.getRecordMetadata().offset();
//                if (offset != null && offset >= 0) {
//                    baseResult.setCode(200);
//                    baseResult.setData(true);
//                    baseResult.setMessage("消息发送成功!");
//                } else {
//                    baseResult = new BaseResult<>(false, 9821, "消息发送失败没有发挥offset值");
//                }
//            } catch (InterruptedException e) {
//                logger.info("SendMessages InterruptedException :{}", JSON.toJSONString(e));
//                baseResult = new BaseResult<>(false, 9821, "消息发送失败请稍后再试");
//            } catch (ExecutionException e) {
//                logger.info("SendMessages ExecutionException :{}", JSON.toJSONString(e));
//                baseResult = new BaseResult<>(false, 9821, "消息发送失败请稍后再试");
//            }
//        } else {
//            baseResult = new BaseResult<>(false, 9871, "消息发送失败");
//        }
//        return baseResult;
//    }
//}
