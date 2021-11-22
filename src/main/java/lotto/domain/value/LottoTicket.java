package lotto.domain.value;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoTicket createTicket(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }
}
