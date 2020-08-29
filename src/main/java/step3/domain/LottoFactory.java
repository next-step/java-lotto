package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final int PICK_COUNT = 6;
    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LottoConfig.FIRST_LOTTO_NUMBER, LottoConfig.LAST_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private LottoFactory() {

    }

    public static List<Lotto> create(int lottoPurchaseCount) {
        return IntStream.range(0, lottoPurchaseCount)
                .mapToObj(i -> new Lotto(pickLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<LottoNo> pickLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(0, PICK_COUNT)
                .stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

}
