package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    private final static String INPUT_MSG = "구매금액을 입력해 주세요";
    private final static String BUY_CNT_MSG = "개를 구매했습니다.";
    private final static String LAST_WINNING_NUMBER_MSG = "지난주 당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_MSG = "보너스 번호를 입력해 주세요";


    public static void main(String[] args) {
        OutputView.printMsg(INPUT_MSG);
        int cnt = InputView.getCount();
        OutputView.printMsg(cnt + BUY_CNT_MSG);

        Lottos lottos = new Lottos(QuickPickGenerator.genLottoNumbers(cnt));

        OutputView.printLottoNumbers(lottos.getLottoNumbers());

        OutputView.printMsg(LAST_WINNING_NUMBER_MSG);

        Lotto winningLotto = new Lotto(new LottoNumbers(InputView.inputWinningNumber()));

        OutputView.printMsg(INPUT_BONUS_MSG);
        LottoNumber bonus = new LottoNumber(InputView.inputNumber());

        WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, bonus);

        OutputView.printWinningResult(lottos.getWinningResult(winningLottoWithBonus));
        OutputView.printRateOfReturnInfo(lottos.getRateOfReturn(winningLottoWithBonus));
    }
}
