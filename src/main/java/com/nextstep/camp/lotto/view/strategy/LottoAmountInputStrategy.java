package com.nextstep.camp.lotto.view.strategy;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

import java.util.Scanner;

public class LottoAmountInputStrategy implements InputStrategy<LottoAmount> {
    private final Scanner scanner;

    private LottoAmountInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public static LottoAmountInputStrategy ofSystemIn() {
        Scanner scanner = new Scanner(System.in);
        return new LottoAmountInputStrategy(scanner);
    }

    public static LottoAmountInputStrategy of(Scanner scanner) {
        return new LottoAmountInputStrategy(scanner);
    }

    @Override
    public LottoAmount read() {
        int intValue = Integer.parseInt(scanner.nextLine());
        return LottoAmount.of(intValue);
    }
}
