package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private static final int LOTTO_NUMBERS_VALIDATE_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Ticket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) {
        long distinctSize = lottoNumbers.stream()
                .distinct()
                .count();

        if (distinctSize != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty() || lottoNumbers.size() != LOTTO_NUMBERS_VALIDATE_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개 여야 합니다", LOTTO_NUMBERS_VALIDATE_SIZE));
        }
    }


    public static Ticket of(List<Integer> numberList) {
        return numberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ticket::new));
    }

    public static Ticket create() {
        return of(LottoNumberGenerator.generate());
    }


    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
