package com.lx.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lx.pk.client.result.BaseResult;

/**
 * Created by chenjiang on 2018/12/14.
 */

public interface TestService {
    /**
     * @return
     */
    public BaseResult<String> testServiceRestlutStr(String id);


}
