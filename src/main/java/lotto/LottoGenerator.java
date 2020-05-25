package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_GENERATE_COUNT = 6;

    private static final LottoNumber LOTTO_NUMBER = new LottoNumber();

    public LottoTicket autoGenerate() {
        List<Integer> defaultLottoNumbers = LOTTO_NUMBER.getDefaultLottoNumbers();

        Collections.shuffle(defaultLottoNumbers);
        LottoTicket lottoTicket = LottoTicket.of(new ArrayList<>(defaultLottoNumbers.subList(0, LOTTO_GENERATE_COUNT)));
        lottoTicket.sort();
        return lottoTicket;
    }
}
