package utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListUtils {
    public static <T> List<T> join(T element, List<T> list) {
        return join(List.of(element), list);
    }

    public static <T> List<T> join(List<T> leftList, List<T> rightList) {
        return Stream.concat(leftList.stream(), rightList.stream())
                .collect(Collectors.toList());
    }
}
