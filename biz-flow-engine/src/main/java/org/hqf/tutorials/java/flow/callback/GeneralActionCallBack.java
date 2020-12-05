package org.hqf.tutorials.java.flow.callback;

import org.hqf.tutorials.java.flow.context.Context;
import org.hqf.tutorials.java.flow.dto.BaseResult;

/**
 * @author hqf
 * @date 2020/12/02
 */
public class GeneralActionCallBack extends AbstractActionCallBack<BaseResult, Context> {

    @Override
    public void paramValidate(Context context) {

    }

    @Override
    public void bizValidate(Context context) {

    }

    @Override
    public void process(Context context) {

    }

    @Override
    public BaseResult assemble(Context context) {
        return null;
    }
}