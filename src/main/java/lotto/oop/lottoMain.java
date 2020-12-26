package lotto.oop;

import lotto.oop.domain.LottoIssue;
import lotto.oop.ui.InputView;

public class lottoMain {
    public static void main(String[] args) {
        InputView input = new InputView();
        input.purchaseInfo();
        LottoIssue lottoIssue = new LottoIssue(input.getCount());
        lottoIssue.publishLottoList();
    }
}
