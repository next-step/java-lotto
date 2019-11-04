package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.view.LottoView;

import java.util.Map;

public class LottoMachine {

    private final LottoView lottoView;
    private LottoNumbers lottoNumbers;
    private Money money;

    public LottoMachine(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        try {
            createLottoNumbers();
            findWinningLotto();
        } catch (NumberFormatException exception) {
            lottoView.showConvertNumberError();
            restart();
        } catch (IllegalArgumentException exception) {
            lottoView.showErrorMessage(exception.getMessage());
            restart();
        }
    }

    private void restart() {
        lottoView.showRestartMessage();
        clear();
        start();
    }

    private void clear() {
        lottoNumbers = null;
        money = null;
    }

    private void createLottoNumbers() {
        money = new Money(lottoView.getMoney());
        lottoNumbers = new LottoNumbers(money.getLottoCount());

        lottoView.showLottoNumbers(lottoNumbers);
    }

    private void findWinningLotto() {
        checkWinningLottoNumber(new LottoNumber(lottoView.getWinningLottoNumbers()));
    }

    private void checkWinningLottoNumber(LottoNumber winningNumber) {
        Map<LottoRank, Long> rankGroup = lottoNumbers.getRankGroup(winningNumber);

        lottoView.showRankResult(rankGroup);
        lottoView.showProfitRate(money.getProfitRate(rankGroup));
    }
}
