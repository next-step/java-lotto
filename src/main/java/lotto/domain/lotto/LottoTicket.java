package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.number.LottoNumbers;
import lotto.domain.winning.WinningNumbers;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<LottoNumbers> lottoNumbers;

    public LottoTicket(int lottoCount, NumberGenerator generator) {
        this.lottoNumbers = createLottoTicket(lottoCount, generator);
    }

    private List<LottoNumbers> createLottoTicket(int lottoCount, NumberGenerator generator) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoNumbers.newLottoNumbersWithNumberGenerator(generator))
                .collect(Collectors.toList());
    }

    public Map<LottoRank, Long> matchWinningNumber(WinningNumbers winningNumbers) {
        return this.lottoNumbers.stream()
                .map(lottoNumber -> LottoRank.valueOf(lottoNumber.matchCount(winningNumbers)))
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
