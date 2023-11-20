package controller;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.type.WinningLevel;
import lotto.WinningNumber;
import util.calculator.Ratio;
import view.Question;
import view.Renderer;

import java.util.ArrayList;
import java.util.List;

import static view.Question.intAsk;

public class LottoController {
    LottoGameState state;

    public void play() {
        init();

        buyLottoPhase();
        inputWinningNumberPhase();
        resultPhase();
    }

    private void init() {
        state = new LottoGameState();
    }

    private void buyLottoPhase() {
        state.setUserInputPurchaseAmount(
                intAsk("구입 금액을 입력해 주세요.")
        );

        state.setUserInputManualLottoCount(
                intAsk("수동으로 구매할 로또 개수를 입력해 주세요.")
        );

        buyManualLottoPhase();

        Renderer.simplePrint("나머지는 자동으로 구매합니다.");
        buyAutoLottoPhase();

        Renderer.simplePrint("수동으로 " + state.getManualLottoCount() + "장, 자동으로 " + state.getAutoLottoCount() + "장 구매했습니다.");
        state.printAllLottos();
    }

    private void buyAutoLottoPhase() {
        state.addAllLottos(
                LottoGenerator.generateRandomLotto(state.getAutoLottoCount())
        );
    }

    private void buyManualLottoPhase() {
        Renderer.simplePrint("수동으로 구매할 로또의 번호를 입력해 주세요.");
        for (int i = 1; i <= state.getManualLottoCount(); i++) {
            List<Integer> userInputLottoNumber = Question.intListAsk("로또 " + i + "장 째: ");
            Lotto lotto = Lotto.of(userInputLottoNumber);
            state.addLotto(lotto);
        }
    }

    private void inputWinningNumberPhase() {
        List<Integer> userInputWinningNumber = Question.intListAsk("지난 주 당첨 번호를 입력해 주세요.");
        int userInputBonusNumber = intAsk("보너스 볼을 입력해 주세요.");

        state.setWinningNumber(
                WinningNumber.of(userInputWinningNumber, userInputBonusNumber)
        );
    }

    private void resultPhase() {
        WinningStatistic result = state.getWinningStatistic();
        Renderer.printResult(result);
        Renderer.printRatio(Ratio.ratio(result.getTotalWinAmount().toInt(), state.getUserInputPurchaseAmount()));
    }
}
