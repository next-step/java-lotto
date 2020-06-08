package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private List<Rank> winnerLottoNumberResult;

    public LottoResult(List<Integer> lottoWinerNumbers) {
        this.winnerLottoNumberResult = setWinnerResult(lottoWinerNumbers);
    }

    private List<Rank> setWinnerResult(List<Integer> lottoWinerNumbers) {
        return lottoWinerNumbers.stream()
                .map(i -> Rank.valueOf(i, false))
                .collect(Collectors.toList());
    }

    public List<Rank> getLottoResult() {
        return this.winnerLottoNumberResult;
    }



}
