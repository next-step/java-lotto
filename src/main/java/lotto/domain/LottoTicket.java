package lotto.domain;

import java.util.*;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public LottoTicket(String stringNumber) {
        this.lottoNumbers = new LottoNumbers(stringNumber);
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> lottoNumber() {
        return Collections.unmodifiableList(lottoNumbers.readOnlyNumbers());
    }
}
