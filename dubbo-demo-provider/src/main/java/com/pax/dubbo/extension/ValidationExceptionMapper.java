package com.pax.dubbo.extension;

import com.alibaba.dubbo.rpc.protocol.rest.RpcExceptionMapper;
import com.changhong.commons.exception.ECodeUtil;
import com.changhong.commons.exception.Error;
import com.changhong.open.commons.ErrorConstant;
import org.springside.modules.beanvalidator.BeanValidators;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by wei9.li@changhong.com on 2015/1/8.
 */
public class ValidationExceptionMapper extends RpcExceptionMapper {
    protected Response handleConstraintViolationException(ConstraintViolationException cve) {

        Map<String, String> msg = BeanValidators.extractPropertyAndMessage(cve.getConstraintViolations());
        Error error = ECodeUtil.getCommError(ErrorConstant.PARAM_VALIDATION_ERROR);
        error.setDes(msg.toString());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).type("application/json").build();

        // 采用json输出代替xml输出
    }
}
