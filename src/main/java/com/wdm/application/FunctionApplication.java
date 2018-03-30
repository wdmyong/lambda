package com.wdm.application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class FunctionApplication {

    public static void main(String[] args) {
        System.out.println();
        Integer incr = incr(i -> i + 1, 10);
        System.out.println(incr);

        convert(i -> i * i + 1, 1);
        convert(Integer::parseInt, "111");
        convert(FunctionApplication::valueOf, 1);
        System.out.println(convert(FunctionApplication::findMaxInt, Arrays.asList(1, 2, 3, 4)));
        System.out.println(convert((List<Integer> list) -> list.stream().max(Comparator
                .comparing(Integer::intValue)).get(), Arrays.asList(1, -1, 2, -2)));
    }

    private static int findMaxInt(List<Integer> list) {
        return list.stream().max(Comparator.comparing(Integer::intValue)).get();
    }

    private static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }

    private static <T>  T incr(Function<T, T> f, T t) {
        return f.apply(t);
    }

    private static <T, R>  R convert(Function<T, R> f, T t) {
        return f.apply(t);
    }
}
