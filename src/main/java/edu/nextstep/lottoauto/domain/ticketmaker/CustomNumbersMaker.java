package edu.nextstep.lottoauto.domain.ticketmaker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomNumbersMaker implements NumbersMaker{

    private final List<Integer> numbers;

    public CustomNumbersMaker(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public CustomNumbersMaker(String numbersOfString) {
        this(createNumbersFromString(numbersOfString));
    }

    @Override
    public List<Integer> create() {
        return numbers;
    }

    private static List<Integer> createNumbersFromString(String numbersString) {
        return Arrays.stream(numbersString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
