package lotto.model;

import lotto.LottoConstants;
import lotto.util.LotteryNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottosGenerator implements LottosGenerator {

    @Override
    public List<Lotto> generate(Money money) {
        if (money == null) {
            throw new NullPointerException();
        }
        int count = money.countOfBuy(LottoConstants.PRICE_PER_ONE);
        money.deduct(moneyOfCount(count));
        return IntStream.iterate(0, i -> i + 1)
            .limit(count)
            .mapToObj(i -> Lotto.from(LotteryNumberGenerator.generate()))
            .collect(Collectors.toList());
    }
}
