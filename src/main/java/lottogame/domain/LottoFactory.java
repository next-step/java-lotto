package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static LottosBundle createLottosBundle(Number count) {
        List<Lottos> multipleLottos = new ArrayList<>();

        while (count.isPositive()) {
            multipleLottos.add(createRandomLottos());
            count = count.decrease();
        }

        return LottosBundle.from(multipleLottos);
    }

    public static LottosBundle createLottosBundle(List<Numbers> numbers) {
        return LottosBundle.fromNumbers(numbers);
    }

    public static Lottos createLotto(Numbers numbers) {
        return Lottos.from(numbers);
    }

    public static WinningLottos createWinningLotto(Numbers numbers, int bonusNumber) {
        return new WinningLottos(numbers, bonusNumber);
    }

    private static Lottos createRandomLottos() {
        return Lottos.from();
    }

    public static Number calculateCountOfLottos(Money money, Money price) {
        return Number.from(money.divide(price).toInt());
    }
}
