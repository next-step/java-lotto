package lotto.tool;

import lotto.domain.LottoBasicNumber;
import lotto.domain.LottoBall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoGenerator {

    private static final int LOTTO_DEFAULT_SIZE = 6;

    public static List<LottoBall> random() {
        LottoShuffler.shuffle(LottoBasicNumber.basicNumbers);
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < LOTTO_DEFAULT_SIZE; i++) {
            lottoBalls.add(new LottoBall(LottoBasicNumber.basicNumbers.get(i)));
        }

        return sort(lottoBalls);
    }

    private static List<LottoBall> sort(List<LottoBall> lottoBalls) {
        Collections.sort(lottoBalls);
        return lottoBalls;
    }
}
