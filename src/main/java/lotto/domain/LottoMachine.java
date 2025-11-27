package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final static int MAX_NUMBER = 45;
    private final static int MIN_NUMBER = 1;
    private final static int COUNT = 6;

    public static int[] createLottoNumbers() {
        List<Integer> nums = new ArrayList<>();
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
            nums.add(i);
        }

        Collections.shuffle(nums);

        return selectLottoNumbers(nums);
    }

    private static int[] selectLottoNumbers(List<Integer> lottoNumbers) {
        int[] nums = new int[COUNT];
        for(int i = 0; i < COUNT; i++){
            nums[i] = lottoNumbers.get(i);
        }
        return nums;
    }
}
