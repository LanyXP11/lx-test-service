package com.lx.test.service;

import com.alibaba.fastjson.JSON;
import com.lx.pk.client.result.BaseResult;
import com.lx.pk.core.constant.ErrorCodeEnum;
import com.lx.pk.core.exception.DubboServiceException;
import com.lx.pk.dubbo.DubboService;
import com.lx.pk.utils.AssertCommonUtil;
import com.lx.service.TestService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjiang on 2018/12/16.
 */
@DubboService
@SuppressWarnings("all")
public class TestServiceImpl implements TestService {

    private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public BaseResult<String> testServiceRestlutStr(String id) {

        BaseResult<String> result = new BaseResult<>();
        try {
            AssertCommonUtil.notNull(id, "id is not null");

            result.setData("Hello World");

        } catch (DubboServiceException de) {
            logger.info("DubboServiceException info:{}", JSON.toJSONString(de));
            result.setCode(de.getCode());
            result.setMessage(de.getMessage());
        } catch (Exception e) {
            logger.error("System Error:{}", e);
            result.setCode(ErrorCodeEnum.SYSTEM_ERROR.getCode());
            result.setMessage(ErrorCodeEnum.SYSTEM_ERROR.getMessage());
        }
        logger.info("DubbService testServiceRestlutStr testServiceRestlutStr Api Result:{}", JSON.toJSONString(result));
        return result;
    }
}
