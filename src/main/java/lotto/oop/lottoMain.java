package lotto.oop;

import lotto.oop.domain.LottoIssue;
import lotto.oop.domain.WinNumber;
import lotto.oop.ui.InputView;
import lotto.oop.ui.ResultView;

public class lottoMain {

    public static void main(String[] args) {
        InputView input = new InputView();
        input.purchaseInfo();
        LottoIssue lottoIssue = new LottoIssue();
        input.printLotto(lottoIssue.publishLottoList(input.getAutoCount(), input.getHandOperationLotto()));
        input.winngNumbersInfo();
        WinNumber winInfo = input.getWinNumberInfo();
        lottoIssue.checkNumber(winInfo.getWinNumbers(), winInfo.getBonusNumber());
        ResultView output = new ResultView(lottoIssue.getIssueStats());
        output.displayIssueStats();
    }
}
