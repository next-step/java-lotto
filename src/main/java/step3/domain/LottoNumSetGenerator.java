package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.LottoNum.MAX_LOTTO_NUM;
import static step3.domain.LottoNum.MIN_LOTTO_NUM;
import static step3.domain.LottoNumSet.LOTTO_NUM_COUNT;

public class LottoNumSetGenerator {
    private static final List<LottoNum> ALL_LOTTO_NUM =
            IntStream.rangeClosed(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
                    .mapToObj(LottoNum::new)
                    .collect(Collectors.toList());

    public static LottoNumSet generateRandomSet() {
        Collections.shuffle(ALL_LOTTO_NUM);
        return new LottoNumSet(ALL_LOTTO_NUM.subList(0, LOTTO_NUM_COUNT));
    }

    public static LottoNumSet generateSet(String lottoNumsInput) {
        List<LottoNum> lottoNums = Arrays.stream(lottoNumsInput.split(","))
                .map(Integer::parseInt)
                .map(LottoNum::new)
                .collect(Collectors.toList());
        return new LottoNumSet(lottoNums);
    }
}
