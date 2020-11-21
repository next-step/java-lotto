package step03.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoGenerator() { }

    public static Lotto generate() {
        List<LottoBall> lottoBalls = Arrays.asList(LottoBall.lottoNumbers);
        Collections.shuffle(lottoBalls);

        return Lotto.of(
                lottoBalls.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList())
        );
    }

}
