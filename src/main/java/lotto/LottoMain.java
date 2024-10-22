package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    private final static String INPUT_MSG = "구매금액을 입력해 주세요";
    private final static String BUY_CNT_MSG = "개를 구매했습니다.";
    private final static String LAST_WINNING_NUMBER_MSG = "지난주 당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_MSG = "보너스 번호를 입력해 주세요";
    private final static String INPUT_MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 번호 수를 입력해 주세요";
    private final static String INPUT_MANUAL_LOTTO_NUMBERS_MSG = "수동으로 구매할 번호를 입력하세요";



    public static void main(String[] args) {
        OutputView.printMsg(INPUT_MSG);
        int inputAmount = InputView.inputNumber();

        OutputView.printMsg(INPUT_MANUAL_LOTTO_COUNT_MSG);
        int manualCount = InputView.inputNumber();

        OutputView.printMsg(INPUT_MANUAL_LOTTO_NUMBERS_MSG);
        List<LottoNumbers> manualLottoNumbers = InputView.inputManualLottoNumbers(manualCount);

        LottoCount lottoCount = new LottoCount(inputAmount, manualCount);

        manualLottoNumbers.addAll(QuickPickGenerator.genLottoNumbers(lottoCount.getAutoLottoCount()));
        Lottos lottos = new Lottos(manualLottoNumbers);

        OutputView.printLottoNumbers(lottos.getLottoNumbers());

        OutputView.printMsg(LAST_WINNING_NUMBER_MSG);
        Lotto winningLotto = new Lotto(new LottoNumbers(InputView.inputWinningNumber()));

        OutputView.printMsg(INPUT_BONUS_MSG);
        LottoNumber bonus = new LottoNumber(InputView.inputNumber());

        WinningResult winningResult = lottos.getWinningResult(new WinningLotto(winningLotto, bonus));

        OutputView.printWinningResult(winningResult);
        OutputView.printRateOfReturnInfo(winningResult.getRateOfReturn(lottoCount));
    }
}
