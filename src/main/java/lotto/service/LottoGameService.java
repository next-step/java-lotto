package lotto.service;

import lotto.domain.LottoGameCount;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottoes;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Objects;

import static lotto.utils.Constants.NUMBER_THOUSAND;

public class LottoGameService {
    private LottoGameCount lottoGameCount;
    private InputView inputView;
    private OutputView outputView;
    private Lottoes lottoes;
    private LottoNumbers lastWeekWinningNumbers;

    public LottoGameService() {

    }

    public LottoGameService(LottoGameCount lottoGameCount, Lottoes lottoes) {
        this.lottoGameCount = lottoGameCount;
        this.lottoes = lottoes;
    }

    public void buyLotto() {
        inputView = new InputView();
        outputView = new OutputView();
        inputView.inputPrice();
        lottoGameCount = inputView.getLottoGameCount();
        outputView.drawLottoGameCount(lottoGameCount);
        lottoes = new Lottoes();
        lottoes.makeLottoes(lottoGameCount);
        outputView.drawPurchasedLottoes(lottoes);
    }

    public void getLastWeekWinningNumbers() {
        lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers();
    }

    public void matchLottoNumbers() {
        lottoes.getLottoGames().forEach(lottoGame -> {
            lottoGame.matchLottoNumbers(lastWeekWinningNumbers);
        });
    }

    public void resultWinLotto() {
        outputView.drawResultWinLotto(lottoes);
    }

    public void resultTotalReward() {
        lottoes.calculateTotalReward();
        outputView.drawTotalReward(calculateYield());
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
                Objects.equals(inputView, that.inputView) &&
                Objects.equals(outputView, that.outputView) &&
                Objects.equals(lottoes, that.lottoes) &&
                Objects.equals(lastWeekWinningNumbers, that.lastWeekWinningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGameCount, inputView, outputView, lottoes, lastWeekWinningNumbers);
    }
}
