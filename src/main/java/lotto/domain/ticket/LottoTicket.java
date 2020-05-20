package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    public static final int LOTTO_NUMBER_SIZE = 6;

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

    public static LottoTicket of(final String numbers) {
        return new LottoTicket(Arrays.stream(numbers.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private void validateNumbers(final List<LottoNumber> numbers) {
        if ((numbers == null) || (numbers.size() != LOTTO_NUMBER_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    public int matchedCount(final WinningLottoTicket winningLottoTicket) {
        return Math.toIntExact(numbers.stream()
                .filter(winningLottoTicket::contains)
                .count());
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
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
