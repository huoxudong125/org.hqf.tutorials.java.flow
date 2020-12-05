package org.hqf.tutorials.java.flow.callback;

import org.hqf.tutorials.java.flow.context.Context;
import org.hqf.tutorials.java.flow.dto.BaseResult;

/**
 * @author hqf
 * @date 2020/12/02
 */
public interface ActionCallBack<T extends BaseResult, C extends Context> {

    void paramValidate(C context);

    void bizValidate(C context);

    void beforeProcess(C context);

    void process(C context);

    void afterProcess(C context);

    T assemble(C context);
}
