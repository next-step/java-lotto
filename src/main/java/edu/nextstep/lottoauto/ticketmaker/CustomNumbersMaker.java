package edu.nextstep.lottoauto.ticketmaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomNumbersMaker implements NumbersMaker{

    private final List<Integer> numbers;
    private final String numbersOfString;


    public CustomNumbersMaker(String numbersOfString) {
        this.numbers = new ArrayList<>();
        this.numbersOfString = numbersOfString;

    }

    public CustomNumbersMaker(List<Integer> numbers) {
        this.numbers = numbers;
        this.numbersOfString = "";
    }

    @Override
    public List<Integer> create() {
        if (numbers.isEmpty()) {
            numbers.addAll(createNumbersFromString(numbersOfString));
        }
        return numbers;
    }

    private static List<Integer> createNumbersFromString(String numbersString) {
        return Arrays.stream(numbersString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
