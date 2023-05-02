package step2.vo;

import step2.service.Lotto;
import step2.service.LottoRank;
import step2.service.LottoRankFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumber {

    private List<LottoNumber> winNumbers;

    private LottoNumber bonusNumber;

    public WinnerNumber(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoRank> countNumOfWinner(List<Lotto> lottoResults) {
        return lottoResults.stream()
                .map(this::countWinNumber)
                .collect(Collectors.toList());
    }

    public LottoRank countWinNumber(Lotto lotto) {
        long countWinNumber = winNumbers.stream()
                .filter(lotto::containWinNumber)
                .count();

        return LottoRankFactory.getLottoRank(countWinNumber, lotto.containBonusNumber(bonusNumber));
    }
}
