package lotto.domain;

import lotto.common.LottoRank;

import java.util.*;

import static java.util.stream.Collectors.toSet;

/**
 * 역할 - 지난주 당첨 번호와 일치하는 개수를 반환한다.
 */
public class LottoTicket {
    private static final String DELIMITER_COMMA = ",";
    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String userInputNumbers) {
        this.lottoNumbers = Arrays.stream(userInputNumbers.split(DELIMITER_COMMA))
                .map(LottoNumber::new)
                .collect(toSet());
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers != null && lottoNumbers.size() == 6) {
            return;
        }

        throw new IllegalArgumentException("잘못된 개수의 로또번호를 입력하셨습니다.");
    }

    public LottoRank matchCount(LottoTicket lottoTicket) {
        HashSet<LottoNumber> matchNumbers = new HashSet<>(this.lottoNumbers);
        matchNumbers.retainAll(lottoTicket.lottoNumbers);
        return LottoRank.getRank(matchNumbers.size());
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

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(this.lottoNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers.toString();
    }
}
