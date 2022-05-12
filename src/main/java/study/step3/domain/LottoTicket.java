package study.step3.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public List<LottoNumber> readOnlyLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers.readOnlyNumbers());
    }
}
