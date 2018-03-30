package com.wdm.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapApplication {


    public static void main(String[] args) {
        List<Gift> giftList = Arrays.asList(new Gift(1, 3), new Gift(2, 2),
                new Gift(3, 3), new Gift(1, 3));
        Map<Integer, Integer> giftCountMap = new HashMap<>();
        Map<Integer, Integer> giftValueMap = new HashMap<>();
        for (Gift gift : giftList) {
            giftCountMap.compute(gift.getId(), (k, v) -> v == null ? 1 : v+ 1);
            giftValueMap.compute(gift.getId(), (k, v) -> v == null ? gift.getValue() : v + gift.getValue());
        }
        outputMap(giftCountMap);
        outputMap(giftValueMap);
    }

    private static class Gift {

        private int id;
        private int value;

        public Gift(int id, int value) {
            this.id = id;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public int getValue() {
            return value;
        }
    }

    private static void outputMap(Map<?, ?> map) {
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "\t" + entry.getValue()));
    }
}
