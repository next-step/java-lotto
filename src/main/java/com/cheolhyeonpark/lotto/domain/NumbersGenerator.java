package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {

    public LottoNumbers getManualLottoNumbers(String input) {
        return new LottoNumbers(getNumberListFromString(input));
    }

    public LottoNumbers getAutoLottoNumbers() {
        return new LottoNumbers(generateAutoNumbers());
    }

    public WinningNumbers getWinningNumbers(String input) {
        return new WinningNumbers(getNumberListFromString(input));
    }

    public BonusNumber getBonusNumber(int input) {
        validateNumber(input);
        return new BonusNumber(input);
    }

    private List<Integer> getNumberListFromString(String input) {
        List<Integer> result;
        result = Arrays.stream(splitStringByComma(input)).map(this::getIntFromString).collect(Collectors.toList());
        result.forEach(this::validateNumber);
        return result;
    }

    private int getIntFromString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("There is non numeric input. Please check your input.");
        }
    }

    private void validateNumber(int number) {
        if (isNotLottoNumber(number)) {
            throw new IllegalArgumentException("You should only enter numbers between 1 and 45.");
        }
    }

    private boolean isNotLottoNumber(int number) {
        return number < 1 || number > 45;
    }

    private String[] splitStringByComma(String input) {
        validateEmptyString(input);
        String [] result = input.trim().replaceAll(" ", "").split(",");
        if (result.length != 6) {
            throw new IllegalArgumentException("Numbers size is not six. You should enter 6 numbers.");
        }
        return result;
    }

    private void validateEmptyString(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("There is no input. Please check your input.");
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.length() < 1;
    }

    private List<Integer> generateAutoNumbers() {
        List<Integer> source = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(source::add);
        Collections.shuffle(source);
        return source.stream().limit(6).collect(Collectors.toList());
    }
}
