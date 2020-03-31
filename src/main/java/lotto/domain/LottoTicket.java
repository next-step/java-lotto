package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
