package lotto.service;

import lotto.domain.BonusLottoNumber;
import lotto.domain.LottoGameCount;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottoes;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Objects;

import static lotto.utils.Constants.NUMBER_THOUSAND;

public class LottoGameService {
    private LottoGameCount lottoGameCount;
    private Lottoes lottoes;
    private LottoNumbers lastWeekWinningNumbers;
    private BonusLottoNumber bonusLottoNumber;

    public LottoGameService() {
        lottoes = new Lottoes();
    }

    public LottoGameService(LottoGameCount lottoGameCount, Lottoes lottoes) {
        this.lottoGameCount = lottoGameCount;
        this.lottoes = lottoes;
    }

    public void buyLotto() {
        InputView.inputPrice();
        lottoGameCount = InputView.getLottoGameCount();
        OutputView.drawLottoGameCount(lottoGameCount);
        lottoes.makeLottoes(lottoGameCount);
        OutputView.drawPurchasedLottoes(lottoes);
    }

    public void getLastWeekWinningNumbers() {
        lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();
    }

    public void getBonusLottonumber() {
        bonusLottoNumber = InputView.inputBonusLottonumber(lastWeekWinningNumbers);
    }

    public void matchLottoNumbers() {
        lottoes.getLottoGames().forEach(lottoGame -> {
            lottoGame.matchLottoNumbers(lastWeekWinningNumbers);
        });
    }

    public void resultWinLotto() {
        OutputView.drawResultWinLotto(lottoes);
    }

    public void resultTotalReward() {
        lottoes.calculateTotalReward();
        OutputView.drawTotalReward(calculateYield());
    }

    public Double calculateYield() {
        return (lottoes.getTotalReward().doubleValue() /
                (lottoGameCount.getLottoGameCount().doubleValue() * NUMBER_THOUSAND));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameService that = (LottoGameService) o;
        return Objects.equals(lottoGameCount, that.lottoGameCount) &&
                Objects.equals(lottoes, that.lottoes) &&
                Objects.equals(lastWeekWinningNumbers, that.lastWeekWinningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGameCount, lottoes, lastWeekWinningNumbers);
    }
}
