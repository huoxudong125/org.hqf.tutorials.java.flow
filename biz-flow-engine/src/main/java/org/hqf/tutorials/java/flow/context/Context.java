package org.hqf.tutorials.java.flow.context;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hqf
 */
public class Context implements Serializable {

    private static final long serialVersionUID = -2728898741940324666L;

    private final Map<Class<?>, Object> CONTEXT = new ConcurrentHashMap<>();

    public <T> T get(Class<T> clazz) {
        return (T) CONTEXT.get(clazz);
    }

    public void put(Object obj) {
        if (null == obj) {
            return;
        }
        CONTEXT.put(obj.getClass(), obj);
    }
}