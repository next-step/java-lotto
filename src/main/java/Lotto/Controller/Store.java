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

        LuckyNumber luckyNumber = getLuckyNumber();
        ResultSummary resultSummary = new ResultSummary(lottos, luckyNumber);
        double profit = resultSummary.getProfit(lottoBuyResource);
        LottoOutput.noticeResult(resultSummary, profit);
    }


    private LuckyNumber getLuckyNumber() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        Lotto luckyNumbers = lottoNumberCreateMachine.getLuckyNumbers(getLuckyNumberSixCount());
        LottoNumber bonusNumber = new LottoNumber(getBonusNumber());
        return new LuckyNumber(luckyNumbers, bonusNumber);
    }

    private List<String> getLuckyNumberSixCount() {
        return LottoInput.getLuckyNumbers();
    }

    private int getBonusNumber() {
        return LottoInput.getBonusNumber();
    }

}
