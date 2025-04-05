package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Lotto.LOTTO_NUM_COUNT;
import static lotto.LottoNumber.*;

public class LottoNumberGenerator {
    private static final List<Integer> numbersPool = new ArrayList<>(lottoNumberMap.keySet());

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
