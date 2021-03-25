package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String SIZE_ERROR_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this(lottoNumbers, LottoNumber.of(45));
    }

    public LottoTicket(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public int matchingLottoNumbersCount(LottoTicket that) {
        return (int) lottoNumbers.stream()
                .filter(that.lottoNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public boolean sameBonusNumber(LottoTicket targetLottoTicket) {
        return true;
    }
}
