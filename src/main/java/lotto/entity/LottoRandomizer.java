package lotto.entity;


import java.util.Collections;
import java.util.List;

public class LottoRandomizer {

    private LottoRandomizer() {

    }

    public static List<Integer> create() {
        List<Integer> initNumbers = LottoNumberRange.initNumber();
        Collections.shuffle(initNumbers);
        return LottoNumberSize.sliceLottoNumbers(initNumbers);
    }
}
