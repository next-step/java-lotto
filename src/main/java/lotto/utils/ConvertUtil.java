package lotto.utils;

import lotto.exception.IllegalStringException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalStringException(input);
        }
    }

    public static List<Integer> toIntegers(List<String> input) {
        return new ArrayList<>(Collections.unmodifiableList(input.stream()
                .map(ConvertUtil::toInt)
                .collect(Collectors.toList())));
    }
}
