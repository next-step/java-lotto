package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        if (this.lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 한장에 중복되지 않는 " + SIZE + "개의 숫자를 입력해야합니다.");
        }
    }

    WinAmount getWinAmount(WinLotto winLotto) {
        int matchCount = (int) winLotto.getWinNumbers().getLottoNumbers().stream()
                .filter(i -> this.lottoNumbers.contains(i))
                .count();
        return WinAmount.valueOfMatchCount(matchCount, this.lottoNumbers.contains(winLotto.getBonusNumber()));
    }

    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNumbers);
        lottoNumberList.sort(Comparator.comparingInt(LottoNumber::getValue));
        return lottoNumberList;
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
