package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private Lotteries lotteries;
    private WinningNumber winningNumbers;

    public LottoResult(Lotteries lotteries, WinningNumber winningNumbers) {
        this.lotteries = lotteries;
        this.winningNumbers = winningNumbers;
    }

    public List<Rank> getRankResult() {
        return lotteries.getLotteries()
                .stream()
                .map(this::getRankResult)
                .collect(Collectors.toList());
    }

    private Rank getRankResult(LottoNumbers lottoNumbers) {

        int matchingCount = lottoNumbers.getWinningCount(winningNumbers.getWinningNumbers());

        if (isSecondRank(lottoNumbers, matchingCount)) {
            return Rank.valueOf(matchingCount, true);
        }

        return Rank.valueOf(matchingCount, false);
    }

    private boolean isSecondRank(LottoNumbers lottoNumbers, int matchingCount) {
        return matchingCount == 5 && lottoNumbers.isMatchBonusBall(winningNumbers.getBonusBall());

    }


}
