package com.example.springbootredis;

import java.util.*;

public class LambdaDemo {

    static String[] atp = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer","Roger Federer",
            "Andy Murray","Tomas Berdych",
            "Juan Martin Del Potro"};
    static List<String> players =  Arrays.asList(atp);

    public static void main(String[] agrs){
//        lambdaForeach();

//        sortDemo();

        createVar();
    }
    static void createVar(){
//        Integer str = (Integer a ,Integer b) -> a + b;
        MathOperation addition = (Integer a, Integer b) -> a + b;
        System.out.println(addition);
    }

    interface MathOperation {
        Integer operation(Integer a, Integer b);
    }


    static void sortDemo(){
        System.out.println("使用Java7排序");
        List<String> names1 = new ArrayList<>();
        names1.add("a");
        names1.add("c");
        names1.add("b");
        names1.add("g");
        names1.add("f");
        //Comparator()构造函数传参只能用String 传人Integer编译错误? 源码构造参数为T
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        for (String str : names1){
            System.out.print(str+",");
        }


        System.out.println("\n\n使用Java8排序");
        List<String> names2 = new ArrayList<>();
        names2.add("a");
        names2.add("c");
        names2.add("b");
        names2.add("g");
        names2.add("f");
        Collections.sort(names2);
        //or以下这种方式也可以进行排序
//        Collections.sort(names2,(s1,s2)->s1.compareTo(s2));
        names2.forEach((e) -> System.out.print(e+","));

    }

    static void lambdaForeach(){
        System.out.println("以前的循环方式");
        for (String player : players) {
            System.out.print(player + "; ");
        }

        System.out.println("\n\n使用 lambda 表达式以及函数操作");
        players.forEach((player) -> System.out.print(player + "; "));

        System.out.println("\n\n在 Java 8 中使用双冒号操作符");
        players.forEach(System.out::print);

//        System.out.println(""+System.out::print);
    }

}
