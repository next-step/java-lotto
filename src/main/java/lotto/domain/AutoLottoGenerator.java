package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBER_CARDS = new ArrayList<>();
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    static {
        for (int i = LOTTO_FIRST_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            LOTTO_NUMBER_CARDS.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> generateLotto() {
        Collections.shuffle(LOTTO_NUMBER_CARDS);
        List<LottoNumber> lottoNumbers = LOTTO_NUMBER_CARDS.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}
