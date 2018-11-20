package lotto;

import lotto.model.Lotto;
import lotto.model.LottosGenerator;
import lotto.model.Money;
import lotto.util.LotteryNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private Money money;

    public LottoGame(Money money) {
        this.money = money;
    }

    public List<Lotto> buy(LottosGenerator ...lottosGenerators) {
        return Arrays.asList(lottosGenerators).stream()
            .flatMap(lottosGenerator -> lottosGenerator.generate(money).stream())
            .collect(Collectors.toList());
    }
}
