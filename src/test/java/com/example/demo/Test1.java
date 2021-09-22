package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test1 {

    private Object num;

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add("1111");
        list.add(1111);
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            System.out.println(str);
        }
    }

    @Test
    public void test2(){
        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        Class aClass = stringList.getClass();
        Class bClass = integerList.getClass();
        System.out.println(aClass);
        System.out.println(aClass.equals(bClass));
    }

    @Test
    public void test3(){
        Generic<String> generica = new Generic<>("bac");
        Generic<Integer> genericb = new Generic<>(123);
        System.out.println(generica.getKey());
        System.out.println(genericb.getKey());
    }

    @Test
    public void test4(){
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(Math.random()).substring(0,6));
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains("0")){
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    public  <T> T genericMethod(Class<T> zClass) throws InstantiationException, IllegalAccessException {
        T t = zClass.newInstance();
        return t;
    }

    @Test
    public void test5() throws  InstantiationException, IllegalAccessException {
        Object o = genericMethod(String.class);
        System.out.println("*******:"+o);
    }

    @Test
    public void test6(){
        String desc  = Type1.getType1ByCode(1).getDesc();
        System.out.println(desc);
    }

}
