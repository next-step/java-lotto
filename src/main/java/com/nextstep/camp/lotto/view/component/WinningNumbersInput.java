package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;
import com.nextstep.camp.lotto.domain.exception.LottoNumbersSizeException;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningNumbersInput extends AbstractInput<WinningNumbers> {

    private static final String WINNING_NUMBER_REGEX = "^\\s*\\d{1,2}\\s*(,\\s*\\d{1,2}\\s*){5}$";;
    private static final String DELIMITER = ",";
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;

    private WinningNumbersInput(Scanner scanner) {
        super(scanner);
    }

    public static WinningNumbersInput create(Scanner scanner) {
        return new WinningNumbersInput(scanner);
    }

    @Override
    protected boolean isValid(String value) {
        return value.matches(WINNING_NUMBER_REGEX);
    }

    @Override
    public String getLabel() {
        return "지난 주 당첨 번호를 입력해 주세요.";
    }

    @Override
    public WinningNumbers getValue() {
        List<Integer> numbers = splitWinningNumbersString();
        validate(numbers);
        return WinningNumbers.of(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new LottoNumbersSizeException();
        }
        if (isOutOfRange(numbers)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private static boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(n -> n < MIN_WINNING_NUMBER || n > MAX_WINNING_NUMBER);
    }

    private List<Integer> splitWinningNumbersString() {
        return Arrays.stream(untypedValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
