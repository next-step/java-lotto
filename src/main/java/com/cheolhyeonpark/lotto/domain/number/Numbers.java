package com.cheolhyeonpark.lotto.domain.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    public static final int NUMBERS_LENGTH = 6;

    private final List<Number> numbers;

    public Numbers() {
        numbers = generateAutoNumbers();
    }

    public Numbers(String input) {
        validate(input);
        List<Number> numbers = getNumberListFromString(input);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        if (!isRightLength(numbers)) {
            throw new IllegalArgumentException("Numbers size is not six. You should enter 6 numbers.");
        }
    }

    private boolean isRightLength(List<Number> numbers) {
        return numbers.size() == NUMBERS_LENGTH;
    }

    public int countSameNumbersAs(Numbers numbers) {
        return Math.toIntExact(this.numbers.stream().filter(numbers::anyMatch).count());
    }

    public boolean anyMatch(Number number) {
        return numbers.stream().anyMatch(number::equals);
    }

    private List<Number> getNumberListFromString(String input) {
        return Arrays.stream(splitStringByComma(input))
                .map(this::getIntFromString).map(Number::new).collect(Collectors.toList());
    }

    private void validate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("There is no input. Please check your input.");
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.length() < 1;
    }

    private int getIntFromString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("There is non numeric input. Please check your input.");
        }
    }

    private String[] splitStringByComma(String input) {
        return input.trim().replaceAll(" ", "").split(",");
    }

    private List<Number> generateAutoNumbers() {
        List<Integer> source = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(source);
        return source.stream().limit(6).map(Number::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
