package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int LAST_LOTTO_NUMBER = 45;
    public static final int PICK_COUNT = 6;

    public static List<Lotto> create(int lottoPurchaseCount) {
        return IntStream.range(0, lottoPurchaseCount)
                .mapToObj(i -> new Lotto(pickLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = IntStream.range(0, LAST_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, PICK_COUNT);
    }

}
