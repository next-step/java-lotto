package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_LENTH = 6;
    private static final int LOTTO_MAX_NUMBER = 46;

    public static ArrayList<Integer> generateRandomNumber() {
        ArrayList<Integer> lottoRangeNumbers = makeLottoNumberRance();
        Collections.shuffle(lottoRangeNumbers);

        ArrayList<Integer> lottoNum = new ArrayList<Integer>();
        for (int i=0; i < LOTTO_NUMBER_LENTH; i++) {
            lottoNum.add(lottoRangeNumbers.get(i));
        }

        return lottoNum;
    }

    private static ArrayList<Integer> makeLottoNumberRance() {
        ArrayList<Integer> lottoNumberRange = new ArrayList<>();

        int i = 1;
        while(i <= LOTTO_MAX_NUMBER) {
            lottoNumberRange.add(i);
            i ++;
        }
        return lottoNumberRange;
    }
}
