package ru.innopolis.stc13.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CounterInvocationHandler implements InvocationHandler {
    Counter counter;

    public CounterInvocationHandler(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = counter.getClass();
        if (clazz.getAnnotation(Logged.class) != null) {
            long start = System.currentTimeMillis();
            System.out.println("Method " + method.getName() + " called");
            Object result = method.invoke(counter, args);
            System.out.println("Operating time: " + (System.currentTimeMillis() - start));
            return result;
        } else {
            return method.invoke(counter, args);
        }
    }
}
