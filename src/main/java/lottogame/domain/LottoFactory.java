package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final int LOTTOS_SIZE = 6;
    private static final int LOTTOS_MIN_NUMBER = 1;
    private static final int LOTTOS_MAX_NUMBER = 45;

    private LottoFactory() {
    }

    public static List<Lottos> createMultipleLottos(Number count) {
        List<Lottos> lottoses = new ArrayList<>();
        while (count.isPositive()) {
            lottoses.add(createRandomLotto());
            count = count.decrease();
        }
        return lottoses;
    }

    public static List<Lottos> createMultipleLottos(List<Numbers> numbers) {
        return numbers.stream().map(LottoFactory::createLotto)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Lottos createLotto(Numbers numbers) {
        return new Lottos(numbers);
    }

    public static WinningLottos createWinningLotto(Numbers numbers, int bonusNumber) {
        return new WinningLottos(numbers, bonusNumber);
    }

    public static boolean isValidLottosSize(int size) {
        return LOTTOS_SIZE == size;
    }

    private static Lottos createRandomLotto() {
        Numbers numbers = Numbers.ofUniqueRandom(LOTTOS_MIN_NUMBER, LOTTOS_MAX_NUMBER);
        return createLotto(numbers.createRandomNumbers(LOTTOS_SIZE));
    }

    public static Number calculateCountOfLottos(Money money, Money price) {
        return Number.from(money.divide(price).toInt());
    }
}
