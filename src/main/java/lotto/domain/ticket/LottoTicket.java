package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoGameProperty.COUNT_OF_LOTTO_NUMBER;

public class LottoTicket {
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(final Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또티켓은 6개의 로또숫자로 이루어져야합니다.");
        }
    }

    public int getMatchCount(LottoTicket lottoTicket) {
        return Math.toIntExact(lottoTicket.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }


    @Override
    public String toString() {
        List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sortedLottoNumbers.sort(Comparator.comparingInt(LottoNumber::getValue));
        return String.valueOf(sortedLottoNumbers);
    }
}
