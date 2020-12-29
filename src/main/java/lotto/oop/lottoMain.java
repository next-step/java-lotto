package lotto.oop;

import lotto.oop.domain.LottoIssue;
import lotto.oop.ui.InputView;
import lotto.oop.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

import static java.util.Arrays.*;

public class lottoMain {
    public static final String COMMA = ",";

    public static void main(String[] args) {
        InputView input = new InputView();
        input.purchaseInfo();
        LottoIssue lottoIssue = new LottoIssue(input.getCount());
        input.printLotto(lottoIssue.publishLottoList());
        input.winngNumbersInfo();
        String[] numbers = input.getWinNumberInfo().get(1).split(COMMA);
        lottoIssue.checkNumber(numbers, input.getWinNumberInfo().get(2));
        ResultView output = new ResultView();
        output.displayIssueStats(lottoIssue.getIssueStats(), input.getAmount());
    }
}
