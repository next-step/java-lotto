package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 46;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto() {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            this.lottoNumbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoTicket buyLottoTicket() {
        Collections.shuffle(lottoNumbers);

        return new LottoTicket(this.lottoNumbers.subList(0, LottoTicket.LOTTO_TICKET_NUMBER));
    }
}
