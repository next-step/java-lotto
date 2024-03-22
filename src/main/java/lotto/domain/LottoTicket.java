package lotto.domain;

import java.util.ArrayList;

import java.util.List;

import static lotto.domain.Rule.MAX_NUMBER;
import static lotto.domain.Rule.NUMBERS_OF_BALLS;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket() {
        this(new LottoNumbers(new ArrayList<>()));
    }

    public List<LottoNumber> generate() {
        return this.lottoNumbers.generate();
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return this.lottoNumbers.countMatchingWith(winningNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

}
