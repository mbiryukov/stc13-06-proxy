package ru.innopolis.stc13.proxy2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Counter realCounter = new MyCounter();
        Counter counterProxy = (Counter) Proxy.newProxyInstance(
                CounterInvocationHandler.class.getClassLoader(),
                new Class[]{Counter.class},
                new CounterInvocationHandler(realCounter)
        );
        System.out.println("Real counter:");
        realCounter.count();
        System.out.println("Proxy counter: ");
        counterProxy.count();
    }
}
