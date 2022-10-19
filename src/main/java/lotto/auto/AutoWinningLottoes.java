package lotto.auto;

import lotto.LottoNumber;
import lotto.LottoWinningStrategy;
import lotto.RANK;
import lotto.SelectedLottoes;

import java.util.List;
import java.util.Optional;

public class AutoWinningLottoes implements LottoWinningStrategy {
    private final List<LottoNumber> winningLottoes;

    public AutoWinningLottoes(List<LottoNumber> winningLottoes) {
        this.winningLottoes = winningLottoes;
    }

    @Override
    public Optional<RANK> calculateWinningResult(SelectedLottoes selectedLottoes) {
        int count = 0;
        for (LottoNumber lotto : selectedLottoes.getSelectedLottoes()) {
            count += winningLottoes.contains(lotto) ? 1 : 0;
        }
        return RANK.findWinningPrize(count, false);
    }

}
