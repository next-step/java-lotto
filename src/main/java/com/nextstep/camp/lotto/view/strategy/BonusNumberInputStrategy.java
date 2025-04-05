package com.nextstep.camp.lotto.view.strategy;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;

import java.util.Scanner;

public class BonusNumberInputStrategy implements InputStrategy<LottoNumber> {
    private final Scanner scanner;

    private static final String BONUS_NUMBER_REGEX = "^\\d{1,2}$";;
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

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
        if (number < MIN_BONUS_NUMBER || number > MAX_BONUS_NUMBER) {
            throw new LottoNumberOutOfRangeException();
        }
    }
}
