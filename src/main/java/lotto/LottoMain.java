package lotto;

import lotto.domain.Buyer;
import lotto.domain.QuickPickGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    private final static String INPUT_MSG = "구매금액을 입력해 주세요";
    private final static String BUY_CNT_MSG = "개를 구매했습니다.";
    private final static String LAST_WINNING_NUMBER_MSG = "지난주 당첨 번호를 입력해 주세요.";


    public static void main(String[] args) {
        OutputView.printMsg(INPUT_MSG);
        int cnt = InputView.getCount();
        OutputView.printMsg(cnt + BUY_CNT_MSG);

        Buyer buyer = new Buyer(cnt, new QuickPickGenerator());

        OutputView.printLottoNumbers(buyer.getLottos());
        OutputView.printMsg(LAST_WINNING_NUMBER_MSG);

        List<Integer> winningNumbers = InputView.inputWinningNumber();

        OutputView.printWinningResult(buyer.getWinningResult(winningNumbers));
        OutputView.printRateOfReturnInfo(buyer.getRateOfReturn(winningNumbers));
    }
}
