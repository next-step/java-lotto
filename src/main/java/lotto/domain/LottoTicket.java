package lotto.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    private static final String NULL_OR_EMPTY_ERROR = "로또 넘버가 NULL 또는 빈문자열 입니다.";
    private static final String DUPLICATE_NUMBER_ERROR = "로또 넘버 갯수가 중복 되었거나 6개가 아닙니다.";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        validateBlank(numbers);
        validateCount(numbers);
        lottoNumbers = numbers;
    }

    public int countMatchNumbers(LottoTicket otherLottoTicket) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber -> otherLottoTicket.getLottoTicketNumbers().contains(lottoNumber))
                .count();
    }

    private void validateBlank(Set<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new NullPointerException(NULL_OR_EMPTY_ERROR);
        }
    }

    private void validateCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    public Set<LottoNumber> getLottoTicketNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean matchLottoNumber(LottoNumber bonusBallNumber) {
        return lottoNumbers.contains(bonusBallNumber) ? true : false;
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
}
