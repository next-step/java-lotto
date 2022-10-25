package lotto.second;

import lotto.LottoNumber;
import lotto.LottoWinningStrategy;
import lotto.RANK;
import lotto.SelectedLottoNumbers;

import java.util.List;
import java.util.Optional;

public class SecondWinningLottoes implements LottoWinningStrategy {

    private final List<LottoNumber> winningLottoes;
    private final LottoNumber bonusLotto;

    public SecondWinningLottoes(List<LottoNumber> winningLottoes, LottoNumber bonusLotto) {
        this.winningLottoes = winningLottoes;
        this.bonusLotto = bonusLotto;
    }

    @Override
    public Optional<RANK> calculateWinningResult(SelectedLottoNumbers selectedLottoNumbers) {
        int count = 0;
        for (LottoNumber winningLotto : winningLottoes) {
            count += selectedLottoNumbers.isWinning(winningLotto) ? 1 : 0;
        }
        return RANK.findWinningPrize(count, selectedLottoNumbers.isWinning(bonusLotto));
    }
}
