package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoTicket {
    private final Integer LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throwException();
        }

        if (LOTTO_NUMBER_COUNT != lottoNumbers.size()) {
            throwException();
        }
    }

    public int matchCount(LottoTicket lastWinningTicket) {
        HashSet<LottoNumber> compareLottoTicket = new HashSet<>(this.lottoNumbers);
        compareLottoTicket.retainAll(lastWinningTicket.lottoNumbers);

        return compareLottoTicket.size();
    }

    private void throwException() {
        throw new IllegalArgumentException("6개의 로또 번호를 입력해주세요");
    }
}
