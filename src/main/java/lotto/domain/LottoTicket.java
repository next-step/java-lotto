package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class LottoTicket {

    public static final int LOTTO_NUMBERS_LENGTH = 6;
    public static final String LOTTO_NUMBERS_LENGTH_ERROR_MESSAGE = "로또 번호는 6자리 수여야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_ERROR_MESSAGE);
        }

        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static LottoTicket of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
