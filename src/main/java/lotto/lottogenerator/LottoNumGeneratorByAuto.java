package lotto.lottogenerator;

import java.util.Collections;
import java.util.List;

public class LottoNumGeneratorByAuto {
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generate() {
        List<Integer> lottoNumbers = LottoNumMaker.makePool();
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}