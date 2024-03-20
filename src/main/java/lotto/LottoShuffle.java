package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffle {
    public static LottoNumbers makeLottoNumbersInRange() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        return new LottoNumbers(nums.subList(0,5));
    }

}
