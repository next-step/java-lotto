package lotto.model;

import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN_LENGTH = 0;
    private static final int LOTTO_NUMBER_MAX_LENGTH = 6;

    private List<Integer> lottoNumber = new ArrayList<>();

    public LottoNumber() {
        for (int number = LottoNumberUtil.getLottoStartNumber(); number <= LottoNumberUtil.getLottoEndNumber(); number++) {
            lottoNumber.add(number);
        }
    }


    public List<Integer> shuffle() {
        Collections.shuffle(lottoNumber);
        return new ArrayList<>(lottoNumber
                .subList(LOTTO_NUMBER_MIN_LENGTH, LOTTO_NUMBER_MAX_LENGTH));
    }

}
