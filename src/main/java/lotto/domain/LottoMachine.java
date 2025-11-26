package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final static int MAX_NUMBER = 45;
    private final static int MIN_NUMBER = 1;
    private final static int COUNT = 6;

    public static List<Integer> createLottoNumbers() {
        List<Integer> nums = new ArrayList<>();
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
            nums.add(i);
        }

        Collections.shuffle(nums);

        return selectLottoNumbers(nums);
    }

    private static List<Integer> selectLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.subList(0,COUNT);
    }
}
