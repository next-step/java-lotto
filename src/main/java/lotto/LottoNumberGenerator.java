package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Lotto.LOTTO_NUM_COUNT;

public class LottoNumberGenerator {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    private static List<Integer> numbersPool = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
            .boxed()
            .collect(Collectors.toList());

    public static List<Lotto> generateLottoNumbers(int lottoQuantity) {
        return IntStream.range(0, lottoQuantity)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<Integer> generateLottoNumbers() {
        Collections.shuffle(numbersPool);
        return numbersPool.stream()
                .limit(LOTTO_NUM_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

}
