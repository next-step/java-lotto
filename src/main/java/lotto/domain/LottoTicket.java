package lotto.domain;

import lotto.domain.strategy.LottoTicketCreateStrategy;
import lotto.enums.Rank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    Set<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateTicketSize(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public static void validateTicketSize(List<Integer> lottoNumberList) {
        if (lottoNumberList.size() != 6) {
            throw new IllegalArgumentException("로또번호는 6개를 입력하셔야합니다");
        }
    }

    public static void validateLottoNumberRange(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(o -> o < 1 || o > 45)) {
            throw new IllegalArgumentException("로또번호는 1~45 사이의 숫자로 입력해야합니다.");
        }
    }

    public static LottoTicket of(LottoTicketCreateStrategy strategy) {
        return new LottoTicket(strategy.getLottoNumbers());
    }

    public int countSameNumber(List<Integer> target) {
        return (int) target.stream().filter(this.lottoNumbers::contains).count();
    }

    public Rank getRank(List<Integer> winNumbers) {
        return Rank.of(countSameNumber(winNumbers));
    }

    public Set<Integer> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
