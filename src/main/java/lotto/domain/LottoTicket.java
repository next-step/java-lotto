package lotto.domain;

import java.util.*;

public class LottoTicket {
    private final LottoNumber lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumber();
    }

    public LottoTicket(String stringNumber) {
        this.lottoNumbers = new LottoNumber(stringNumber);
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumber(lottoNumbers);
    }

    public List<Integer> lottoNumber() {
        return Collections.unmodifiableList(lottoNumbers.readOnlyWinnerNumbers());
    }

    public LottoRank rank(LottoNumber winnerNumber) {
        return LottoRank.findLottoRank(this, winnerNumber);
    }
}
