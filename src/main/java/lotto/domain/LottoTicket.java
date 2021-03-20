package lotto.domain;

import lotto.strategy.Auto;
import lotto.strategy.Manual;
import lotto.strategy.Numbers;

import java.util.*;

public class LottoTicket {
    private final Numbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new Auto();
    }

    public LottoTicket(String stringNumber) {
        this.lottoNumbers = new Manual(stringNumber);
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = new Auto(lottoNumbers);
    }

    public List<Integer> lottoNumber() {
        return Collections.unmodifiableList(lottoNumbers.readOnlyNumbers());
    }
}
