package ru.innopolis.stc13.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainingCenter implements InvocationHandler {
    private Trainer trainer;

    public TrainingCenter(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("talk")) {
            System.out.println("who's late");
        }
        if (method.getName().equals("eat")) {
            System.out.println("Robots don't eat");
        }
        return method.invoke(trainer, args);
    }
}
