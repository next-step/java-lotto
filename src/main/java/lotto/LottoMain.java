package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    private final static String LAST_WINNING_NUMBER_MSG = "지난주 당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_MSG = "보너스 번호를 입력해 주세요";


    public static void main(String[] args) {
        LottoBuyDetails lottoBuyDetails = InputView.inputBuyDetails();

        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorFactory(lottoBuyDetails).createGenerator());

        OutputView.printPurchaseDetails(lottoBuyDetails);
        OutputView.printLottoNumbers(lottoGame.getLottoNumbers());

        OutputView.printMsg(LAST_WINNING_NUMBER_MSG);
        Lotto winningLotto = new Lotto(new LottoNumbers(InputView.inputWinningNumber()));

        OutputView.printMsg(INPUT_BONUS_MSG);
        LottoNumber bonus = new LottoNumber(InputView.inputNumber());

        WinningResult winningResult = lottoGame.getWinningResult(new WinningLotto(winningLotto, bonus));

        OutputView.printWinningResult(winningResult);
        OutputView.printRateOfReturnInfo(winningResult.getRateOfReturn(lottoBuyDetails));
    }

}
