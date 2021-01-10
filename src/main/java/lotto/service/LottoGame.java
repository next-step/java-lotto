package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinnerNumber;
import lotto.domain.Lottos;
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
        Lottos manualLotto = createManualLotto(coin);
        Lottos autoLotto = new Lottos();
        autoLotto.createAutoNumber(coin - manualLotto.getLottoSize());
        Lottos integrationLotto = new Lottos();
        integrationLotto.combineLotto(manualLotto, autoLotto);
        ResultView.printBuyLottoNumber(integrationLotto.getLottoList(), manualLotto.getLottoSize(), autoLotto.getLottoSize());
        return integrationLotto;
    }

    public Lottos createManualLotto(int coin) {
        return new Lottos(InputView.inputBuyManualLotto(coin));
    }

    public int changeCoin(int money) {
        lottoMoney = new LottoMoney(money);
        return lottoMoney.getCoin();
    }
}
