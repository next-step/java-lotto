package lotto;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.util.LotteryNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public List<Lotto> buy(Money money) {
        return IntStream.iterate(0, i -> i + 1)
            .limit(money.countOfBuy(LottoConstants.PRICE_PER_ONE))
            .mapToObj(i -> Lotto.from(LotteryNumberGenerator.generate()))
            .collect(Collectors.toList());
    }
}
