package com.epam.exercises.circularbuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircularBufferApp {
    public static void main(String[] args) {
        CircularBuffer<String> buffer = new CircularBuffer<String>(5);
//        String[] strings = buffer.toArray();
//        buffer.get();

//        put, addAll
        buffer.put("First");
        buffer.addAll(new ArrayList<String>(Arrays.asList("Second", "Third", "Fourth", "Fifth")));
//        buffer.put("Sixth");

//        get
        String tail = buffer.get();
        System.out.println("Tail had value - " + tail);
        System.out.println(buffer.toString());
        String tail2 = buffer.get();
        System.out.println("Tail had value - " + tail2);
        System.out.println(buffer.toString());

//        addAll
//        buffer.addAll(new ArrayList<String>(Arrays.asList("Sixth", "Seventh")));
        CircularBuffer<Integer> bufferInteger = new CircularBuffer<Integer>(4);
        bufferInteger.addAll(new ArrayList<Integer>(Arrays.asList(3, 1, 2)));
        System.out.println(bufferInteger.toString());

//        toObjectArray
        Object[] objects = bufferInteger.toObjectArray();
        System.out.println("length of objects - " + objects.length);

//        toArray
        Integer[] integers = bufferInteger.toArray();
        System.out.println("length of integers - " + integers.length);

//        asList
        List<Integer> integersList = bufferInteger.asList();
        System.out.println(integersList.toString());

//        sort
        bufferInteger.sort(getComparator());
        System.out.println(bufferInteger);
    }

    private static Comparator<Integer> getComparator() {
        return new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else if (o2 == null) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        };
    }
}

