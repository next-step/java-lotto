package lotto.tool;

import lotto.domain.LottoBall;

import java.util.Collections;
import java.util.List;

public class LottoShuffler {

    public static void shuffle2(List<LottoBall> numbers) {
        Collections.shuffle(numbers);
    }

    public static void shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}

