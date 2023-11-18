package controller;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.rule.WinningLevelDetermination;
import lotto.type.WinningLevel;
import lotto.WinningNumber;
import util.calculator.Ratio;
import view.Question;
import view.Renderer;

import java.util.List;

public class LottoController {
    private int userInputPurchaseAmount = 0;
    private List<Lotto> lottos;
    private WinningNumber winningNumber;

    public void play() {
        buyLottoPhase();
        inputWinningNumberPhase();
        resultPhase();
    }

    private void buyLottoPhase() {
        userInputPurchaseAmount = Question.intAsk("구입 금액을 입력해 주세요.");

        int lottoAmount = userInputPurchaseAmount / 1000;
        Renderer.simplePrint(lottoAmount + "개를 구매했습니다.");

        lottos = LottoGenerator.generateRandomLotto(lottoAmount);
        for (Lotto myLotto : lottos) {
            Renderer.printLotto(myLotto);
        }
    }

    private void inputWinningNumberPhase() {
        List<Integer> userInputWinningNumber = Question.intListAsk("지난 주 당첨 번호를 입력해 주세요.");
        int userInputBonusNumber = Question.intAsk("보너스 볼을 입력해 주세요.");

        winningNumber = WinningNumber.of(userInputWinningNumber, userInputBonusNumber);
    }

    private void resultPhase() {
        WinningStatistic result = new WinningStatistic();
        for (Lotto myLotto : lottos) {
            WinningLevel rank = WinningLevelDetermination.whatRank(myLotto, winningNumber);
            result.occurs(rank);
        }
        Renderer.printResult(result);

        Renderer.printRatio(Ratio.ratio(result.getTotalWinAmount().toInt(), userInputPurchaseAmount));
    }

}
