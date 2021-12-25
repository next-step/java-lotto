package lotto.controller;

import lotto.*;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoController {

    private static final LottoNumberMachineImpl LOTTO_NUMBER_MACHINE = new LottoNumberMachineImpl();
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.outputView = new OutputView();
    }

    public Lottos buyLottos(long moneyForLotto) {
        Lottos lottos = lottoMachine.buyLottos(moneyForLotto, LOTTO_NUMBER_MACHINE);
        showBoughtLottos(lottos);

        return lottos;
    }

    public WinnerLotto getWinnerLotto(String lottoWinNumbers, int bonusNumber) {
        return new WinnerLotto(lottoWinNumbers, bonusNumber);
    }

    public LottoResult calculateLottoResult(Lottos boughtLottos, WinnerLotto winnerLotto) {
        LottoResult lottoResult = lottoMachine.calculateMatchCount(boughtLottos, winnerLotto);
        showMatchCounts(lottoResult);

        return lottoResult;
    }

    public void calculateTotalProfit(LottoResult lottoResult) {
        BigDecimal profit = lottoMachine.calculateProfit(lottoResult);
        showTotalProfit(profit);
    }

    private void showBoughtLottos(Lottos lottos) {
        outputView.showHowManyLottosBoughtWithMoney(lottos);
        outputView.showLottos(lottos);
    }

    private void showMatchCounts(LottoResult lottoResult) {
        Map<Rank, Integer> winnersLottResult = lottoResult.getWinnersLottoResult();
        outputView.showMatchCount(winnersLottResult);
    }

    private void showTotalProfit(BigDecimal totalProfit) {
        outputView.showLottoProfit(totalProfit);
    }

}
