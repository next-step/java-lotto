package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.numberdrawer.ShuffledNumberDrawer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Scanner;

public class LottoGame {
    public static final String INPUT_START_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int countOfLotto = inputView.lottoCount(INPUT_START_MESSAGE);

        LottoNumbers lottoNumbers = LottoMachine.createLottoNumbers(countOfLotto, new ShuffledNumberDrawer());
        outputView.printLottoNumbers(lottoNumbers);

        LottoNumber winningNumber = inputView.winnnigNumbersInput(INPUT_WINNING_NUMBER_MESSAGE);

        LottoResult lottoResult = lottoNumbers.computeLottoResult(winningNumber);
        outputView.printResult(lottoResult);
    }
}
