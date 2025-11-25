package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoNumber {
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
        List<LottoNumber> result = new ArrayList<>();
        for(int i = 1; i <= COUNT; i++){
            result.add(lottoNumbers.get(i));
        }
        return result;
    }
}
