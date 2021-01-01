package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.LottoMoney;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinnerNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoService {

    private LottoMoney lottoMoney;
    private Lottos lottos;
    private LottoWinnerNumber lottoWinnerNumber;
    private LottoStatistics lottoStatistics;

    public void lottoGame() {
        changeCoin();
        createLottoNumber();
        createWinnerNumbers();
        statistics();
        ResultView.statistics(lottoStatistics, lottoMoney);
    }

    private void statistics() {
        lottoStatistics = new LottoStatistics();
        lottoStatistics.confirmOfLottoNumber(lottos, lottoWinnerNumber);
    }

    private void createWinnerNumbers() {
        lottoWinnerNumber = new LottoWinnerNumber();
        lottoWinnerNumber.splitStringNumbers(InputView.inputPrizeNumbers());
    }

    private void createLottoNumber() {
        lottos = new Lottos();
        lottos.createAutoNumber(lottoMoney.getCoin());
        ResultView.printBuyLottoNumber(lottos.getLottoList());
    }

    private void changeCoin() {
        lottoMoney = new LottoMoney(InputView.inputPurchaseAmount());
        ResultView.printCoinAndRemainMoney(lottoMoney);
    }
}
