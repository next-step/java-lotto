package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_GENERATE_COUNT = 6;

    public LottoTicket autoGenerate() {
        List<LottoNumber> defaultLottoNumbers = LottoNumbers.getDefaultLottoNumbers();

        Collections.shuffle(defaultLottoNumbers);

        List<LottoNumber> subLottoNumbers = defaultLottoNumbers.subList(0 , LOTTO_GENERATE_COUNT);
        return LottoTicket.of(new HashSet<>(subLottoNumbers));
    }
}
