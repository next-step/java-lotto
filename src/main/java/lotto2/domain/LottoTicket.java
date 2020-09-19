package lotto2.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 역할 - 지난주 당첨 번호와 일치하는 개수를 반환한다.
 */
public class LottoTicket {

    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers != null && lottoNumbers.size() == 6) {
            return;
        }

        throw new IllegalArgumentException("잘못된 개수의 로또번호를 입력하셨습니다.");
    }

    public int matchCount(LottoTicket lottoTicket) {
        HashSet<LottoNumber> matchNumbers = new HashSet<>(this.lottoNumbers);
        matchNumbers.retainAll(lottoTicket.lottoNumbers);
        return matchNumbers.size();
    }
}
