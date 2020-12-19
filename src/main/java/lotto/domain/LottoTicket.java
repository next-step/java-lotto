package lotto.domain;

import lotto.exception.LottoNumberCountNotEnoughException;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        Optional.ofNullable(numbers)
                .filter(lottoNumbers -> lottoNumbers.size() == LOTTO_NUMBER_COUNT)
                .orElseThrow(LottoNumberCountNotEnoughException::new);

        lottoNumbers = numbers;
    }

    public int countMatchNumbers(LottoTicket otherLottoTicket) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber -> otherLottoTicket.getLottoTicketNumbers().contains(lottoNumber))
                .count();
    }

    public Set<LottoNumber> getLottoTicketNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean matchLottoNumber(LottoNumber bonusBallNumber) {
        return lottoNumbers.contains(bonusBallNumber);
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
