package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yuanfei
 * @description:
 * @date: Create in 2021/9/13 16:17
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LambdaTest {

    List<String> list = new ArrayList<String>(){{
        add("111");
        add("111");
        add("2");
        add("3");
        add("3");
        add("21");
        add("32");
    }};
    // 集合的遍历forEach方法
    @Test
    public void testForEach(){

       list.forEach(s -> System.out.println(s));
    }

    // 将操作后的对象转化为新的对象
    @Test
    public void testCollect(){
        List<Integer> newList = list.stream().map(s -> {
            //// 过滤掉我们希望留下来的值
            return Integer.valueOf(s);
        }).collect(Collectors.toList());
        System.out.println(newList);
    }

    // Filter 为过滤的意思，只要满足 Filter 表达式的数据就可以留下来，不满足的数据被过滤掉
    @Test
    public void testFilter(){
        List<String> collect = list.stream().filter(s -> {
            return s.equals("111");
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    // map 方法可以让我们进行一些流的转化，比如原来流中的元素是 A，通过 map 操作，可以使返回的流中的元素是 B
    @Test
    public void testMap(){
        List<String> list1 = new ArrayList<String>(){{
            add("asd");
            add("sdf");
            add("vbc");
            add("sewer");
            add("asdad");
        }};
        List<String> collect = list1.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);
    }

    // mapToInt 方法的功能和 map 方法一样，只不过 mapToInt 返回的结果已经没有泛型，已经明确是 int 类型的流了
    @Test
    public void testMapToInt(){
        List<Integer> collect = list.stream().mapToInt(s ->{
            return Integer.valueOf(s);
        })
                /*
                一定要有 mapToObj，因为 mapToInt 返回的是 IntStream，因为已经确定是 int 类型了
                所有没有泛型的，而 Collectors.toList() 强制要求有泛型的流，所以需要使用 mapToObj
                方法返回有泛型的流
                 */
                .mapToObj(s -> s)
                .collect(Collectors.toList());

        // DoubleStream/IntStream 有许多 sum（求和）、min（求最小值）、max（求最大值）、average（求平均值）等方法
        double sum = list.stream().mapToDouble(s -> Double.valueOf(s)).sum();
        System.out.println(sum);
        System.out.println(collect);
    }

    // distinct 方法有去重的功能
    @Test
    public void testDistinct(){
        List<Integer> collect = list.stream().map(s -> {
            return Integer.valueOf(s);
        }).distinct().collect(Collectors.toList());

        System.out.println(collect);
    }

    // Sorted 方法提供了排序的功能，并且允许我们自定义排序
    @Test
    public void testSorted(){
        List<Integer> collect = list.stream().map(s -> Integer.valueOf(s)).distinct()
                // 等同于 .sorted(Comparator.naturalOrder()) 自然排序
                .sorted().collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect1 = list.stream().map(s -> Integer.valueOf(s))
                .distinct()
                // 倒序
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(collect1);
    }


    // groupingBy 是能够根据字段进行分组，toMap 是把 List 的数据格式转化成 Map 的格式
    @Test
    public void testGroupingBy(){
        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> {
            if ("1".equals(s.substring(0, 1))) {
                return "1";
            } else if ("2".equals(s.substring(0, 1))) {
                return "2";
            } else {
                return "3";
            }
        }));
        System.out.println(collect);
    }

    // findFirst 表示匹配到第一个满足条件的值就返回
    @Test
    public void testFindFirst(){
        String s1 = list.stream().filter(s -> "9".equals(s.substring(0, 1)))
                .findFirst()
                // orElse 表示如果 findFirst 返回 null 的话，就返回 orElse 里的内容
                .orElse("2");
        System.out.println(s1);

        Optional<String> first = list.stream().filter(s -> "1".equals(s.substring(0, 1))).findFirst();
        // isPresent 为 true 的话，表示 value != null
        if (first.isPresent()){
            return;
        }
    }

    // reduce 方法允许我们在循环里面叠加计算值
    @Test
    public void testReduce(){
        Integer integer = list.stream().map(s -> {
           return Integer.valueOf(s);
        })
                // // s1 和 s2 表示循环中的前后两个数
                .reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(integer);

        Integer reduce = list.stream().map(s -> Integer.valueOf(s))
                // 第一个参数表示基数，会从 100 开始加
                .reduce(100, (s1, s2) -> s1 + s2);
        System.out.println(reduce);
    }

    //peek 方法很简单，我们在 peek 方法里面做任意没有返回值的事情，比如打印日志
    @Test
    public void testPeek(){
        list.stream().map(s -> Integer.valueOf(s))
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());
    }

    // limit 方法会限制输出值个数，入参是限制的个数大小
    @Test
    public void testLimit(){
        List<Integer> collect = list.stream().map(s -> Integer.valueOf(s))
                .limit(2L).collect(Collectors.toList());
        System.out.println(collect);
    }

    // 通过max、min方法，可以获取集合中最大、最小的对象通过max、min方法，可以获取集合中最大、最小的对象
    @Test
    public void testMaxMin(){
        String s1 = list.stream().max(Comparator.comparing(s -> Integer.valueOf(s))).get();
        String s2 = list.stream().min(Comparator.comparing(s -> Integer.valueOf(s))).get();
        System.out.println(s1);
        System.out.println(s2);
    }
}
