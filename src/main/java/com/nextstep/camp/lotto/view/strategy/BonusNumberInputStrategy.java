package com.nextstep.camp.lotto.view.strategy;

import java.util.Scanner;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;

public class BonusNumberInputStrategy implements InputStrategy<LottoNumber> {
    private final Scanner scanner;

    private static final String BONUS_NUMBER_REGEX = "^\\d{1,2}$";;

    private BonusNumberInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public static BonusNumberInputStrategy ofSystemIn() {
        return new BonusNumberInputStrategy(new Scanner(System.in));
    }

    public static BonusNumberInputStrategy of(Scanner scanner) {
        return new BonusNumberInputStrategy(scanner);
    }

    @Override
    public LottoNumber read() {
        String value = scanner.nextLine();
        validate(value);
        int number = Integer.parseInt(value);
        validateRange(number);
        return LottoNumber.of(number);
    }

    private void validate(String value) {
        if (!value.matches(BONUS_NUMBER_REGEX)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private void validateRange(int number) {
        if (number < LottoNumber.MIN_VALUE || number > LottoNumber.MAX_VALUE) {
            throw new LottoNumberOutOfRangeException();
        }
    }
}
