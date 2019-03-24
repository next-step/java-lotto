package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_LENTH = 6;
    private static final int LOTTO_MAX_NUMBER = 46;
    private List<Integer> lottoRangeNumbers;

    public LottoGenerator() {
        lottoRangeNumbers = makeLottoNumberRange();
    }

    public List<Integer> generateRandomNumber() {
        Collections.shuffle(this.lottoRangeNumbers);

        List<Integer> lottoNum = new ArrayList<Integer>();
        for (int i=0; i < LOTTO_NUMBER_LENTH; i++) {
            lottoNum.add(this.lottoRangeNumbers.get(i));
        }

        return lottoNum;
    }

    private static List<Integer> makeLottoNumberRange() {
        List<Integer> lottoNumberRange = new ArrayList<>();

        int i = 1;
        while(i <= LOTTO_MAX_NUMBER) {
            lottoNumberRange.add(i);
            i ++;
        }

        return lottoNumberRange;
    }
}
