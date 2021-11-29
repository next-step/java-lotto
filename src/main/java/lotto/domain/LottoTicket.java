package lotto.domain;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public int matchOfNumberCount(LottoTicket lottoTicket) {
        return (int) numbers.stream()
            .filter(lottoTicket.numbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
