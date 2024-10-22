package lotto.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WinningTexts {

    private WinningTexts() {

    }

    public static Set<Integer> numbers(String[] text) {
        return toInts(text);
    }

    private static Set<Integer> toInts(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(toInt(value));
        }
        return new HashSet<>(result);
    }

    private static Integer toInt(String value) {
        return Integer.parseInt(value);
    }

}
