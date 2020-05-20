package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private Set<LottoNumber> numbers;

    private LottoTicket() {
    }

    private LottoTicket(final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = new LinkedHashSet<>(numbers);
    }

    public static LottoTicket of(final List<Integer> numbers) {
        return new LottoTicket(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private void validateNumbers(final List<LottoNumber> numbers) {
        if ((numbers == null) || (numbers.size() != 6)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
       return "["
               + numbers.stream()
                        .map(number -> String.valueOf(number.getNumber()))
                        .collect(Collectors.joining(", "))
               + "]";
    }
}
