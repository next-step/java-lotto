package Lotto.Controller;

import Lotto.model.*;
import Lotto.view.LottoInput;
import Lotto.view.LottoOutput;

import java.util.List;

public class Store {


    public void buyLotto() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        LottoBuyResource lottoBuyResource = new LottoBuyResource(LottoInput.getPrice());
        Lottos lottos = lottoNumberCreateMachine.createLottos(lottoBuyResource);
        LottoOutput.noticeBuyLotto(lottos);
        Lotto luckyNumbers = lottoNumberCreateMachine.getLuckyNumbers(getLuckyNumber());
        ResultSummary resultSummary = new ResultSummary(lottos, luckyNumbers);
        double profit = resultSummary.getProfit(lottoBuyResource);
        LottoOutput.noticeResult(resultSummary, profit);
    }

    private List<String> getLuckyNumber() {
        return LottoInput.getLuckyNumbers();
    }

}
