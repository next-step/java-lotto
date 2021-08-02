package lotto.domain;

import java.util.Set;

class LottoTicket {
    private Set<LottoNumber> lottoNumbers;

    LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.generateNumbers();
    }

}
