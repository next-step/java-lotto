package lotto.domain.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoTicket createTicket(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
