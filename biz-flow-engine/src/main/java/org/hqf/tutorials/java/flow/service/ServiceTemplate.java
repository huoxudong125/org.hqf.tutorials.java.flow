package org.hqf.tutorials.java.flow.service;

import org.hqf.tutorials.java.flow.callback.AbstractActionCallBack;
import org.hqf.tutorials.java.flow.context.Context;
import org.hqf.tutorials.java.flow.dto.BaseResult;

/**
 * @author hqf
 * @date 2020/12/02
 */
public interface ServiceTemplate<T extends BaseResult,C extends Context> {

    /**
     * @param context
     * @param action
     * @return
     */
    T invoke(C context, AbstractActionCallBack<T, C> action);
}
