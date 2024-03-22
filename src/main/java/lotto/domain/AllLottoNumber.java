package lotto.domain;

import java.util.Collections;
import java.util.List;

public class AllLottoNumber {

    private static final List<LottoNumber> LOTTO_NUMBERS = LottoNumber.getLottoNumbers();


    public static List<LottoNumber> shuffle() {
        Collections.shuffle(LOTTO_NUMBERS);
        return Collections.unmodifiableList(LOTTO_NUMBERS);
    }

}
