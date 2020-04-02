package lotto.lottogenerator;

import lotto.model.lottonumber.LottoNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumGeneratorByAuto {
    private static final int LOTTO_SIZE = 6;

    public static List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = LottoNumMaker.makePool();
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, LOTTO_SIZE);
        lottoNumbers.sort(Comparator.comparing(LottoNumber::getLottoNumber));
        return lottoNumbers;
    }
}