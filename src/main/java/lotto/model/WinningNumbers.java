package lotto.model;

import java.util.List;

public class WinningNumbers {

    private List<Rank> winnerLottoNumbers;

    public WinningNumbers(List<Rank> winnerLottoNumbers) {
        this.winnerLottoNumbers = winnerLottoNumbers;
    }

    public int getWinnerCount(int matchingCount) {
        return (int) winnerLottoNumbers
                        .stream()
                        .filter(o -> o.getCountOfMatch() == matchingCount)
                        .count();
    }

    public int getTotalPrize() {
        return winnerLottoNumbers.stream().mapToInt(Rank::getWinningMoney).sum();
    }


}
