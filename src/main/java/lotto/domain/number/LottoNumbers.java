package lotto.domain.number;

import lotto.domain.ticket.WinningLottoTicket;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final int LOTTO_NUMBER_SIZE = 6;

    private Set<LottoNumber> numbers;

    private LottoNumbers() {
    }

    private LottoNumbers(final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = new LinkedHashSet<>(numbers);
    }

    public static LottoNumbers of(final List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public static LottoNumbers of(final String numbers) {
        return new LottoNumbers(Arrays.stream(numbers.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private void validateNumbers(final List<LottoNumber> numbers) {
        if ((numbers == null) || (numbers.size() != LOTTO_NUMBER_SIZE)) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d개 여야 합니다.", LOTTO_NUMBER_SIZE));
        }
    }

    public int matchCount(final WinningLottoTicket winningLottoTicket) {
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
