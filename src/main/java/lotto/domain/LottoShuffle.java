package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffle {
    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;
    private static final int DRAW_START_RANGE = 0;
    private static final int DRAW_END_RANGE = 5;

    public static LottoNumbers makeLottoNumbersInRange() {
        List<Integer> nums = new ArrayList<>();

        for (int i = LOTTO_START_RANGE; i <= LOTTO_END_RANGE; i++) {
            nums.add(i);
        }

        Collections.shuffle(nums);

        return new LottoNumbers(nums.subList(DRAW_START_RANGE, DRAW_END_RANGE));
    }

}
