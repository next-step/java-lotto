package lotto.controller;

import lotto.exception.NanException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private Splitter() {}

    static List<Integer> splitStringToIntegers(String string, String regex) {
        return split(string, regex)
                .stream()
                .map(Splitter::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw NanException.getInstance();
        }
    }

    private static List<String> split(String str, String regex) {
        return Arrays.asList(
                str.split(regex)
        );
    }
}
