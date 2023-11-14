package me.namuhuchutong.lotto.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.Numbers;

public class UserInputInformation {

    private static final String NON_NUMERIC_REGEX = "^[,\\s\\d]+$";
    private static final String INPUT_NUMBER_REGEX = ", ";

    private final int amount;

    private final String numbers;

    private final Number bonusNumber;

    public UserInputInformation(int amount, String numbers, int bonusNumber) {
        validateZeroOrNegative(amount);
        validateNonNumeric(numbers);
        this.amount = amount;
        this.numbers = numbers;
        validateDuplicatedNumbers(bonusNumber);
        this.bonusNumber = new Number(bonusNumber);
    }

    private void validateDuplicatedNumbers(int bonusNumber) {
        String[] split = this.numbers.split(INPUT_NUMBER_REGEX);
        Set<String> numberSet = new HashSet<>(Arrays.asList(split));
        if (numberSet.contains(String.valueOf(bonusNumber))) {
            throw new IllegalArgumentException("보너스 넘버는 기존 입력된 넘버와 중복될 수 없습니다.");
        }
    }

    private void validateNonNumeric(String numbers) {
        String[] split = numbers.split(NON_NUMERIC_REGEX);
        if (split.length != 0) {
            throw new IllegalArgumentException("로또 번호만 입력할 수 있습니다.");
        }
    }

    private void validateZeroOrNegative(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("금액은 0 혹은 음수일 수 없습니다.");
        }
    }

    public int getAmount() {
        return this.amount;
    }

    public Numbers getNumbers() {
        String[] split = this.numbers.split(INPUT_NUMBER_REGEX);
        List<Number> collect = Stream.of(split)
                                     .map(character -> new Number(Integer.parseInt(character)))
                                     .collect(Collectors.toUnmodifiableList());
        return new Numbers(collect);
    }

    public Number getBonusNumber() {
        return this.bonusNumber;
    }
}