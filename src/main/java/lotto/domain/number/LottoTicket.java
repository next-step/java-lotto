package lotto.domain.number;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private List<LottoNumber> numbers;

    private LottoTicket() {
    }

    private LottoTicket(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket of(final List<Integer> numbers) {
        return new LottoTicket(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }
}
