package com.java8.ftrs;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Main extends Object{


    public static void main(String[] args) {
//        List<String> myList = new ArrayList<String>();
//
//        myList.add("1");
//        myList.add("2");
//        myList.add("3");
//        myList.add("4");
//        myList.add("5");

      //  Iterator<String> it = myList.iterator();
//        while (it.hasNext()) {
//            String value = it.next();
//            System.out.println("List Value:" + value);
//            if (value.equals("3"))
//                myList.add("new");
//        }
//        Iterator has problem of concurrent modification exception problem if not handled properly
//
//        myList.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//        myList.forEach((s)-> System.out.println(s));

        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        //using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));

      //  Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        List<Integer> collect = sequentialStream.filter(h -> h > 90).map(h -> h + 100).collect(Collectors.toList());
        System.out.println(collect);
        //highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

        Integer reduce = collect.stream().reduce(0, (sum, price) -> (sum + price));
        System.out.println(reduce);
        Integer collect1 = collect.stream().collect(Collectors.summingInt(s -> s));
        System.out.println(collect1);
        Integer integer = collect.stream().max((p1, p2) -> (p1 > p2) ? 1 : -1).get();
        collect = new ArrayList<>();
        collect.add(1000);
        collect.add(999);
        collect.add(888);
        Integer integer1 = collect.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1 is "+o1+" and o2 is "+o2);
                return (o1 < o2) ? -1 : 1;
            }
        }).get();
        long count = collect.stream().filter((s) -> s == 99).count();
        System.out.println(count);
        System.out.println(integer1);

        LocalDate date = LocalDate.now(ZoneId.of("Asia/Kol"));
        LocalDate date1 = LocalDate.ofEpochDay(2);


    }
}
