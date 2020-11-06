package lotto.domain.lotto;

import lotto.domain.exception.InvalidMoneyException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private int lottosCount;
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottosCount = lottos.size();
        this.lottos = lottos;
    }

    public static Lottos withMoney(int money) {
        validateMoney(money);
        int lottosCount = money / Lotto.PRICE;
        List<Lotto> lottos = IntStream.range(0, lottosCount)
                .mapToObj(i -> Lotto.ofNumbers(LottoNumberGenerator.getNumbers()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private static void validateMoney(int money) {
        if (money < 0) {
            throw new InvalidMoneyException();
        }
    }

    public int getCount() {
        return lottosCount;
    }
}
