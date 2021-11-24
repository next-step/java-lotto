package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public int matchOfNumberCount(LottoTicket lottoTicket) {
        return (int) numbers.stream()
            .filter(lottoTicket.numbers::contains).count();
    }
}
