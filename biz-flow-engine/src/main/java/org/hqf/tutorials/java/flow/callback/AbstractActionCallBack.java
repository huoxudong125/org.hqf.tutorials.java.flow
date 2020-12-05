package org.hqf.tutorials.java.flow.callback;

/**
 * @author hqf
 * @date 2020/12/02
 */

import org.hqf.tutorials.java.flow.context.Context;
import org.hqf.tutorials.java.flow.dto.BaseResult;

/**
 * @Description: 流程引擎-抽象执行事件接口
 * @author: orangeCs
 * @create: 2020-08-22
 */
public abstract class AbstractActionCallBack<T extends BaseResult,C extends Context> implements ActionCallBack<T,C> {

    @Override
    public void beforeProcess(C context) {

    }

    @Override
    public void afterProcess(C context) {

    }
}