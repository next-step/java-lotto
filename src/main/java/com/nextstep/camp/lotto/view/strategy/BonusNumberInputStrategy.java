package com.nextstep.camp.lotto.view.strategy;

import java.util.Scanner;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class BonusNumberInputStrategy implements InputStrategy<WinningNumbers> {
    private final Scanner scanner;
    private final WinningNumbers winningNumbers;

    private static final String BONUS_NUMBER_REGEX = "^\\d{1,2}$";;
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private BonusNumberInputStrategy(Scanner scanner, WinningNumbers winningNumbers) {
        this.scanner = scanner;
        this.winningNumbers = winningNumbers;
    }

    public static BonusNumberInputStrategy ofSystemIn(WinningNumbers winningNumbers) {
        return new BonusNumberInputStrategy(new Scanner(System.in), winningNumbers);
    }

    public static BonusNumberInputStrategy of(Scanner scanner, WinningNumbers winningNumbers) {
        return new BonusNumberInputStrategy(scanner, winningNumbers);
    }

    @Override
    public WinningNumbers read() {
        String value = scanner.nextLine();
        validate(value);
        int number = Integer.parseInt(value);
        validateRange(number);
        LottoNumber lottoNumber = LottoNumber.of(number);
        return winningNumbers.withBonusNumber(lottoNumber);
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
