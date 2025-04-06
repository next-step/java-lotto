package com.nextstep.camp.lotto.view.strategy;

import java.util.Scanner;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.lotto.domain.vo.LottoCount;

public class LottoManuelCountInputStrategy implements InputStrategy<LottoCount> {
    private final Scanner scanner;

    private LottoManuelCountInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public static LottoManuelCountInputStrategy ofSystemIn() {
        Scanner scanner = new Scanner(System.in);
        return new LottoManuelCountInputStrategy(scanner);
    }

    public static LottoManuelCountInputStrategy of(Scanner scanner) {
        return new LottoManuelCountInputStrategy(scanner);
    }

    @Override
    public LottoCount read() {
        int intValue = Integer.parseInt(scanner.nextLine());
        return LottoCount.of(intValue);
    }
}
