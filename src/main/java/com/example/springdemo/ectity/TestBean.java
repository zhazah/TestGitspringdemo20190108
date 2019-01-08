package com.example.springdemo.ectity;

public class TestBean {
    private TestBean(){}
    private String name;
    private static volatile TestBean testBean = null;

    public static TestBean getInstance(){
        if(testBean == null){
            synchronized (TestBean.class){
                if(testBean == null){
                    testBean = new TestBean();
                }
            }
        }
        return testBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo(){
        System.out.println("My name is " + name);
    }
}
