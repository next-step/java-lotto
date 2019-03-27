package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_RANGE_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUMBER = 46;
    private List<Integer> lottoRangeNumbers;

    public LottoGenerator() {
        lottoRangeNumbers = makeLottoNumberRange();
    }

    public LottoNumbers generateRandomNumber() {
        Collections.shuffle(this.lottoRangeNumbers);

        List<Integer> lottoNum = new ArrayList<Integer>();
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBER_SIZE; i++) {
            lottoNum.add(this.lottoRangeNumbers.get(i));
        }

        return new LottoNumbers(lottoNum);
    }
    // TODO :: https://github.com/next-step/java-lotto/pull/139
    private static List<Integer> makeLottoNumberRange() {
        List<Integer> lottoNumberRange = new ArrayList<>();

        int i = LOTTO_RANGE_MIN_NUM;
        while(i <= LOTTO_MAX_NUMBER) {
            lottoNumberRange.add(i);
            i ++;
        }

        return lottoNumberRange;
    }
}
