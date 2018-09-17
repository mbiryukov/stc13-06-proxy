package ru.innopolis.stc13.proxy2;

@Logged
public class MyCounter implements Counter {
    @Override
    public void count() {
        System.out.println("1-2-3-4");
    }
}
