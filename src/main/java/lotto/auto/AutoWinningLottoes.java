package lotto.auto;

import lotto.LottoNumber;
import lotto.LottoWinningStrategy;
import lotto.RANK;
import lotto.SelectedLottoNumbers;

import java.util.List;
import java.util.Optional;

public class AutoWinningLottoes implements LottoWinningStrategy {
    private final List<LottoNumber> winningLottoes;

    public AutoWinningLottoes(List<LottoNumber> winningLottoes) {
        this.winningLottoes = winningLottoes;
    }

    @Override
    public Optional<RANK> calculateWinningResult(SelectedLottoNumbers selectedLottoNumbers) {
        int count = 0;
        for (LottoNumber winningLotto : winningLottoes) {
            count += getWinningCount(selectedLottoNumbers, winningLotto);
        }
        return RANK.findWinningPrize(count, false);
    }

    private int getWinningCount(SelectedLottoNumbers selectedLottoNumbers, LottoNumber winningLotto) {
        if (selectedLottoNumbers.isWinning(winningLotto)) {
            return 1;
        }
        return 0;
    }

}
