package lotto.domain.lotto;

import lotto.domain.LottoIssueRequest;
import lotto.domain.number.generator.NumberGenerator;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.winning.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<LottoNumbers> lottoNumbers;

    public LottoTicket(LottoIssueRequest lottoIssueRequest, NumberGenerator<LottoNumber> generator) {
        this.lottoNumbers = createLottoTicket(lottoIssueRequest, generator);
    }

    private List<LottoNumbers> createLottoTicket(LottoIssueRequest lottoIssueRequest, NumberGenerator<LottoNumber> generator) {
        List<LottoNumbers> manualLottoNumbers = createManualLottoNumbers(lottoIssueRequest.getManualNumbers());
        List<LottoNumbers> autoLottoNumbers = createAutoLottoNumbers(lottoIssueRequest, generator);

        List<LottoNumbers> allLottoNumbers = new ArrayList<>();
        allLottoNumbers.addAll(manualLottoNumbers);
        allLottoNumbers.addAll(autoLottoNumbers);

        return allLottoNumbers;
    }

    private List<LottoNumbers> createManualLottoNumbers(List<List<Integer>> manualNumbers) {
            return manualNumbers.stream()
                    .map(LottoNumbers::manualLottoNumber)
                    .collect(Collectors.toList());
    }

    private List<LottoNumbers> createAutoLottoNumbers(LottoIssueRequest lottoIssueRequest, NumberGenerator<LottoNumber> generator) {
        int autoLottoCount = lottoIssueRequest.getPrice().getLottoCount() - lottoIssueRequest.getManualNumbers().size();

        return IntStream.range(0, autoLottoCount)
                .mapToObj(i -> LottoNumbers.autoLottoNumber(generator))
                .collect(Collectors.toList());
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
