package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Objects;

public class LottoGameService {
    private LottoGameCount lottoGameCount;
    private Lottoes lottoes;
    private LottoNumbers lastWeekWinningNumbers;
    private BonusLottoNumber bonusLottoNumber;
    private LottoResult lottoResult;

    public LottoGameService() {
        lottoes = new Lottoes();
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
            lottoGame.matchingCount(lastWeekWinningNumbers);
            lottoGame.matchingBonus(bonusLottoNumber);
        });
    }

    public void resultWinLotto() {
        lottoResult = new LottoResult();
        lottoResult.calculateResultWin(lottoes.getLottoGames());
        OutputView.drawResultWinLotto(lottoGameCount, lottoResult);
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
