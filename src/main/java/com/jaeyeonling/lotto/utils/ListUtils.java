package com.jaeyeonling.lotto.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public final class ListUtils {

    private ListUtils() { }

    public static <E> List<E> concat(final List<E> list1,
                                     final List<E> list2) {
        final List<E> concatList = createList(list1, list2);

        concatList.addAll(list1);
        concatList.addAll(list2);

        return concatList;
    }

    public static boolean isNullOrEmpty(final List<?> list) {
        return list == null || list.isEmpty();
    }

    private static <E> List<E> createList(final List<E> list1,
                                          final List<E> list2) {
        if (isRandomAccess(list1) && isRandomAccess(list1)) {
            return new ArrayList<>(list1.size() + list2.size());
        }
        return new LinkedList<>();
    }

    private static boolean isRandomAccess(final List<?> list) {
        return list instanceof RandomAccess;
    }
}
