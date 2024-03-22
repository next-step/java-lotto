package lotto.controller;

import lotto.domain.*;
import lotto.numberdrawer.ShuffledNumberDrawer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static final String INPUT_START_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int countOfLotto = inputView.lottoCount(INPUT_START_MESSAGE);

        LottoNumbers lottoNumbers = LottoMachine.createLottoNumbers(countOfLotto, new ShuffledNumberDrawer());
        outputView.printLottoNumbers(lottoNumbers);

        LottoNumber inputWinningNumber = inputView.winnnigNumbersInput(INPUT_WINNING_NUMBER_MESSAGE);
        MyNumber bonusNumber = inputView.getBonusNumber(INPUT_BONUS_NUMBER_MESSAGE, inputWinningNumber);

        LottoResult lottoResult = lottoNumbers.computeLottoResult(new WinningNumber(inputWinningNumber, bonusNumber));
        outputView.printResult(lottoResult);
    }
}
