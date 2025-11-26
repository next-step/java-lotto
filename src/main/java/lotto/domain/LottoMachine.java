package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final static int MAX_NUMBER = 45;
    private final static int MIN_NUMBER = 1;
    private final static int COUNT = 6;


    public static List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> nums = new ArrayList<>();
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
            nums.add(new LottoNumber(i));
        }

        Collections.shuffle(nums);

        return selectLottoNumbers(nums);
    }

    private static List<LottoNumber> selectLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.subList(0,COUNT);
    }
}
