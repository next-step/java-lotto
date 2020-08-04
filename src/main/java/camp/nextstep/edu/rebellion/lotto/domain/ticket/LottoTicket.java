package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
