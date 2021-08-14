package lotto.domain;

import java.util.List;

public class LottoTicket {

    List<Integer> lottoNumbers;

    public LottoTicket() {
        lottoNumbers = LottoNumberSelector.selectNumbers();
    }
}
