package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
