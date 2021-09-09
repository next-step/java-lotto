package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoShop {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int manualLottoCount = InputView.inputManualLottoCount();
        List<Lotto> manualLottoList = InputView.inputManualLotto(manualLottoCount);
        AffordableLottoCount affordableLottoCount = new AffordableLottoCount(new Money(money), manualLottoCount);
        LottoMachine lottoMachine = new LottoMachine(affordableLottoCount, manualLottoList, new AutoGenerateNumsStrategy());

        ResultView.printBuyableLottoNum(affordableLottoCount.getCountToManualGenerate(), affordableLottoCount.getCountToAutoGenerate());
        ResultView.printGeneratedLottos(lottoMachine.getLottos(), affordableLottoCount);

        List<Integer> winningNums = InputView.inputWinningNums();
        int bonusNum = InputView.inputBonusNum();
        WinningNumber winningNumber = new WinningNumber(winningNums, bonusNum);

        ResultView.printLottoPrize(lottoMachine.getWinningResult(winningNumber));
        ResultView.printLottoYield(lottoMachine.getYield(winningNumber));
    }
}
