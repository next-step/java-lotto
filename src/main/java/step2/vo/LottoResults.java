package step2.vo;

import step2.service.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

    private final List<Lotto> lottoResults;

    public LottoResults(List<Lotto> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public List<Lotto> getLottoResults() {
        return lottoResults;
    }

    public List<Integer> countNumOfWinner(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        return lottoResults.stream()
                .map(lotto -> lotto.countWinNum(winNumbers))
                .collect(Collectors.toList());
    }
}
