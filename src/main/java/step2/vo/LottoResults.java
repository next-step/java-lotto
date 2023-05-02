package step2.vo;

import step2.service.Lotto;
import step2.service.LottoRank;

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

    public List<LottoRank> countNumOfWinner(WinnerNumber winnerNumber) {
        return winnerNumber.countNumOfWinner(lottoResults);
    }
}
