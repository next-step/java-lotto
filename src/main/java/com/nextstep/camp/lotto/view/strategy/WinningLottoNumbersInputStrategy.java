package com.nextstep.camp.lotto.view.strategy;

import java.util.*;
import java.util.stream.Collectors;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.exception.*;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;

public class WinningLottoNumbersInputStrategy implements InputStrategy<LottoNumbers> {
    private final Scanner scanner;

    private static final String WINNING_NUMBER_REGEX = "^\\s*\\d{1,2}\\s*(,\\s*\\d{1,2}\\s*){5}$";;
    private static final String DELIMITER = ",\\s?";

    private WinningLottoNumbersInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public static WinningLottoNumbersInputStrategy ofSystemIn() {
        Scanner scanner = new Scanner(System.in);
        return new WinningLottoNumbersInputStrategy(scanner);
    }

    public static WinningLottoNumbersInputStrategy of(Scanner scanner) {
        return new WinningLottoNumbersInputStrategy(scanner);
    }

    @Override
    public LottoNumbers read() {
        String value = scanner.nextLine();
        validate(value);
        List<Integer> numbers = splitWinningNumbersString(value);
        validate(numbers);
        return LottoNumbers.of(numbers);
    }

    private static void validate(String value) {
        if (!value.matches(WINNING_NUMBER_REGEX)) {
            throw new LottoNumberInputRegexException();
        }
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumbers.LOTTO_NUMBERS_SIZE) {
            throw new LottoNumbersSizeException();
        }
        if (isOutOfRange(numbers)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private static boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(n -> n < LottoNumber.MIN_VALUE || n > LottoNumber.MAX_VALUE);
    }

    private List<Integer> splitWinningNumbersString(String value) {
        return Arrays.stream(value.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
