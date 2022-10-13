package Lotto.Controller;

import Lotto.model.*;
import Lotto.view.LottoInput;
import Lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public void buyLotto() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        LottoBuyResource lottoBuyResource = new LottoBuyResource(LottoInput.getPrice(), LottoInput.getManualLottoCount());
        Lottos manualLottos = getManualLottos(lottoBuyResource.getManualLottoCount());
        Lottos lottos = lottoNumberCreateMachine.createLottos(lottoBuyResource, manualLottos);
        LottoOutput.noticeBuyLotto(lottos, lottoBuyResource);

        LuckyNumber luckyNumber = getLuckyNumber();
        ResultSummary resultSummary = new ResultSummary(lottos, luckyNumber);
        double profit = resultSummary.getProfit(lottoBuyResource);
        LottoOutput.noticeResult(resultSummary, profit);
    }

    private Lottos getManualLottos(int manualLottoCount) {
        LottoOutput.AskManualLottoNumber();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            Lotto lottoNumber = LottoInput.getLottoNumber();
            LottoOutput.printLottoNumber(lottoNumber);
            lottos.add(lottoNumber);
        }
        return new Lottos(lottos);
    }


    private LuckyNumber getLuckyNumber() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        Lotto luckyNumbers = getLuckyNumbers();
        LottoNumber bonusNumber = new LottoNumber(getBonusNumber());
        return new LuckyNumber(luckyNumbers, bonusNumber);
    }

    private Lotto getLuckyNumbers() {
        LottoOutput.AskLuckyNumber();
        return LottoInput.getLottoNumber();
    }

    private int getBonusNumber() {
        return LottoInput.getBonusNumber();
    }

}
