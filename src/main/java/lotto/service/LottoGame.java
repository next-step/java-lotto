package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.LottoMoney;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinnerNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private LottoMoney lottoMoney;

    public void start() {
        statistics(
                createLottoNumber(changeCoin(InputView.inputPurchaseAmount())),
                createWinnerNumbers(InputView.inputPrizeNumbers(), InputView.inputBonusNumber())
        );
    }

    private void statistics(Lottos lottos, LottoWinnerNumber lottoWinnerNumber) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.confirmOfLottoNumber(lottos, lottoWinnerNumber);
        ResultView.statistics(lottoStatistics, lottoMoney);
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
