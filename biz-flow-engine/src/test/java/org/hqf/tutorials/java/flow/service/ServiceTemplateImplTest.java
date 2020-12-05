package org.hqf.tutorials.java.flow.service;

import org.hqf.tutorials.java.flow.context.Context;
import org.hqf.tutorials.java.flow.dto.BaseResult;

import static org.junit.Assert.*;

public class ServiceTemplateImplTest {

    @org.junit.Test
    public void invoke() {
        //构造上下文
        Context context = new Context();
        context.put(10);

        StudentAction studentAction = new StudentAction();

        ServiceTemplate serviceTemplate = new ServiceTemplateImpl();
        final BaseResult invoke = serviceTemplate.invoke(context, studentAction);
        System.out.println(invoke.getData());
    }
}