package controller;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.type.WinningLevel;
import lotto.WinningNumber;
import util.calculator.Ratio;
import view.Question;
import view.Renderer;

import java.util.List;

public class LottoController {
    public void play() {
        int purchaseAmount = Question.intAsk("구입 금액을 입력해 주세요.");

        int lottoAmount = purchaseAmount / 1000;

        Renderer.simplePrint(lottoAmount + "개를 구매했습니다.");
        List<Lotto> lottos = LottoGenerator.generateRandomLotto(lottoAmount);

        for (Lotto myLotto : lottos) {
            Renderer.printLotto(myLotto);
        }

        List<Integer> userInputWinningNumber = Question.intListAsk("지난 주 당첨 번호를 입력해 주세요.");

        WinningNumber winningNumber = WinningNumber.of(userInputWinningNumber);

        WinningStatistic result = new WinningStatistic();
        for (Lotto myLotto : lottos) {
            WinningLevel rank = winningNumber.whatRank(myLotto);
            result.occurs(rank);
        }
        Renderer.printResult(result);

        Renderer.printRatio(Ratio.ratio(result.getTotalWinAmount().toInt(), lottoAmount));
    }
}
