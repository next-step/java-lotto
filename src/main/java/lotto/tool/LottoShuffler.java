package lotto.tool;

import lotto.domain.LottoBall;

import java.util.Collections;
import java.util.List;

public class LottoShuffler {

    public static void shuffle(List<LottoBall> numbers) {
        Collections.shuffle(numbers);
    }
}