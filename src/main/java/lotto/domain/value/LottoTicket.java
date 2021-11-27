package lotto.domain.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoTicket createTicket(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(
                lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList()));
    }
}
