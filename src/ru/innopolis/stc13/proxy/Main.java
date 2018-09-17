package ru.innopolis.stc13.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Trainer mikhail =
                new JavaTrainer();
        TrainingCenter trainingCenter =
                new TrainingCenter(mikhail);

        Trainer stc = (Trainer) Proxy.newProxyInstance(
                TrainingCenter.class.getClassLoader(),
                new Class[]{Trainer.class},
                trainingCenter);
        System.out.println("Without proxy:");
        mikhail.eat();
        mikhail.teach();
        System.out.println("With proxy:");
        stc.teach();
        stc.eat();
        stc.talk();
        System.out.println(
                "Fake stc:"
        );
        Trainer fakeStc = (Trainer) Proxy.newProxyInstance(
                TrainingCenter.class.getClassLoader(),
                new Class[]{Trainer.class},
                new FakeTrainingCenter());
        fakeStc.teach();
        fakeStc.talk();
        fakeStc.eat();
    }
}
