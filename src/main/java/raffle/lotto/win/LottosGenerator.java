package raffle.lotto.win;

import raffle.lotto.Lotto;
import raffle.lotto.money.Money;

import java.util.List;

@FunctionalInterface
public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
