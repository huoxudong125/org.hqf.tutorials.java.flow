package org.hqf.tutorials.java.flow.service;

import org.hqf.tutorials.java.flow.callback.GeneralActionCallBack;
import org.hqf.tutorials.java.flow.context.Context;
import org.hqf.tutorials.java.flow.dto.BaseResult;

/**
 * @author hqf
 * @date 2020/12/02
 */
public class StudentAction extends GeneralActionCallBack {

    @Override
    public BaseResult assemble(Context context){
        BaseResult baseResult=new BaseResult();
        baseResult.setData(context.get(Integer.class));
        return baseResult;
    }
}
