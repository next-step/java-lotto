package lotto.domain;

import java.util.*;

public class LottoAutoGenerator implements GenerateStrategy {
    private static int MAX_LOTTO_COUNT = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    public List<LottoNumber> getLottoNumbers() {
        return shuffle(generateNumbers()).subList(0, MAX_LOTTO_COUNT);
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        List<LottoNumber> temp = new ArrayList<>();

        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            temp.add(LottoNumber.of(i));
        }
        return temp;
    }

    private List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
