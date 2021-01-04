package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.LottoMoney;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinnerNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private LottoMoney lottoMoney;
    private LottoStatistics lottoStatistics;

    public void start() {
        ResultView.statisticsPrint(statistics(
                createLottoNumber(changeCoin(InputView.inputPurchaseAmount())),
                createWinnerNumbers(InputView.inputPrizeNumbers(), InputView.inputBonusNumber())),lottoMoney
        );
    }

    public LottoStatistics statistics(Lottos lottos, LottoWinnerNumber lottoWinnerNumber) {
        lottoStatistics = new LottoStatistics();
        lottoStatistics.confirmOfLottoNumber(lottos, lottoWinnerNumber);
        return lottoStatistics;
    }

    public LottoWinnerNumber createWinnerNumbers(String winnerNumbers, int BonusNumber) {
        return new LottoWinnerNumber(winnerNumbers, BonusNumber);
    }

    public Lottos createLottoNumber(int coin) {
        Lottos lottos = new Lottos();
        lottos.createAutoNumber(coin);
        ResultView.printBuyLottoNumber(lottos.getLottoList());
        return lottos;
    }

    public int changeCoin(int money) {
        lottoMoney = new LottoMoney(money);
        ResultView.printCoinAndRemainMoney(lottoMoney);
        return lottoMoney.getCoin();
    }
}
