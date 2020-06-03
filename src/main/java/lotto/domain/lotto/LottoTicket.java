package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.winning.WinningLotto;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumbers> lottoNumbers;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Map<LottoRank, Long> matchWinningNumber(WinningLotto winningLotto, LottoNumber bonusNumber) {
        return this.lottoNumbers.stream()
                .map(lottoNumbers -> LottoRank.valueOf(winningLotto.matchCount(lottoNumbers), lottoNumbers.matchCount(bonusNumber)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoNumbersCount() {
        return this.lottoNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
