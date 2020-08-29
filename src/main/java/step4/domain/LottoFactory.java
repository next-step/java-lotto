package step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final int PICK_COUNT = 6;
    private static final List<LottoNo> LOTTO_NOS = IntStream.rangeClosed(LottoConfig.FIRST_LOTTO_NUMBER, LottoConfig.LAST_LOTTO_NUMBER)
            .mapToObj(LottoNo::new)
            .collect(Collectors.toList());

    private LottoFactory() {

    }

    public static List<Lotto> create(int lottoPurchaseCount) {
        return IntStream.range(0, lottoPurchaseCount)
                .mapToObj(i -> new Lotto(pickLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<LottoNo> pickLottoNumbers() {
        Collections.shuffle(LOTTO_NOS);
        return LOTTO_NOS.subList(0, PICK_COUNT)
                .stream()
                .collect(Collectors.toList());
    }

}
