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

public class LottoController {
    private int userInputPurchaseAmount;
    private int userInputManualLottoCount;
    private List<Lotto> lottos;
    private WinningNumber winningNumber;

    public void play() {
        buyLottoPhase();
        inputWinningNumberPhase();
        resultPhase();
    }

    private void buyLottoPhase() {
        lottos = new ArrayList<>();

        userInputPurchaseAmount = Question.intAsk("구입 금액을 입력해 주세요.");
        int totalLottoCount = userInputPurchaseAmount / 1000;

        userInputManualLottoCount = Question.intAsk("수동으로 구매할 로또 개수를 입력해 주세요.");
        int autoLottoCount = totalLottoCount - userInputManualLottoCount;

        buyManualLottoPhase(userInputManualLottoCount);

        Renderer.simplePrint("나머지는 자동으로 구매합니다.");
        buyAutoLottoPhase(autoLottoCount);

        Renderer.simplePrint("수동으로 " + userInputManualLottoCount + "장, 자동으로 " + autoLottoCount + "장 구매했습니다.");
        for (Lotto myLotto : lottos) {
            Renderer.printLotto(myLotto);
        }
    }

    private void buyAutoLottoPhase(int autoLottoCount) {
        lottos.addAll(
                LottoGenerator.generateRandomLotto(autoLottoCount)
        );
    }

    private void buyManualLottoPhase(int lottoCount) {
        Renderer.simplePrint("수동으로 구매할 로또의 번호를 입력해 주세요.");
        for (int i = 1; i <= lottoCount; i++) {
            List<Integer> userInputLottoNumber = Question.intListAsk("로또 " + i + "장 째: ");
            Lotto lotto = Lotto.of(userInputLottoNumber);
            lottos.add(lotto);
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
            WinningLevel rank = WinningLevel.decideFinalWinningLevel(myLotto, winningNumber);

            result.occurs(rank);
        }
        Renderer.printResult(result);

        Renderer.printRatio(Ratio.ratio(result.getTotalWinAmount().toInt(), userInputPurchaseAmount));
    }
}
