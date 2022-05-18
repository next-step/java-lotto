package study.step4.domain;

import java.util.Collections;
import java.util.Set;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(Set<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public Set<LottoNumber> readOnlyLottoNumber() {
        return Collections.unmodifiableSet(lottoNumbers.readOnlyNumbers());
    }
}
