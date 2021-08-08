package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 한장에 " + SIZE + "개의 숫자를 입력해야합니다.");
        }

        Collections.sort(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    WinAmount getWinAmount(WinLotto winLotto) {
        int matchCount = (int) winLotto.getWinNumbers().getLottoNumbers().stream()
                .filter(i -> this.lottoNumbers.contains(i))
                .count();
        return WinAmount.valueOfMatchCount(matchCount, this.lottoNumbers.contains(winLotto.getBonusNumber()));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
