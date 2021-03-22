package lotto.domain;

import java.util.*;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public List<LottoNumber> readOnlyLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers.readOnlyNumbers());
    }
}
