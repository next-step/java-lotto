package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumbers> lottoNumbers;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
