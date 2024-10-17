package lotto.entity;


import java.util.Collections;
import java.util.List;

public class LottoRandomizer {

    private LottoRandomizer() {

    }

    public static List<Integer> create() {
        final LottoNumberRange lottoNumberRange = new LottoNumberRange();
        List<Integer> initNumbers = lottoNumberRange.getLottoNumbers();
        Collections.shuffle(initNumbers);
        return LottoNumberSize.sliceLottoNumbers(initNumbers);
    }
}
