package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static final int LOTTOS_SIZE = 6;

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

    public static List<Lottos> createMultipleLottos(List<List<Integer>> numbers) {
        return numbers.stream().map(LottoFactory::createLotto)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Lottos createLotto(List<Integer> numbers) {
        return new Lottos(numbers);
    }

    public static WinningLottos createWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLottos(numbers, bonusNumber);
    }

    public static boolean isValidLottosSize(int size) {
        return LOTTOS_SIZE == size;
    }

    private static Lottos createRandomLotto() {
        Collections.shuffle(numbers);
        return createLotto(numbers
                .subList(0, LOTTOS_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList()));
    }

    public static Number calculateCountOfLottos(Money money, Money price) {
        return Number.from(money.divide(price).toInt());
    }
}
