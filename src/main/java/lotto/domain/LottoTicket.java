package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "자리 입니다. ");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return getLottoNumbers()
                .stream()
                .map(n -> n.toInt())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","))
                +"]";
    }
}
