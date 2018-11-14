package raffle.domain.lotto.win;

import raffle.domain.lotto.Lotto;
import raffle.domain.lotto.money.Money;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
