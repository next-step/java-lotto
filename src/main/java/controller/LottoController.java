package controller;

import controller.validation.LottoCount;
import controller.validation.LottoPurchaseAmount;
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

    private LottoPurchaseAmount userInputPurchaseAmount;
    private LottoCount totalLottoCount;
    private LottoCount userInputManualLottoCount;
    private LottoCount autoLottoCount;

    private final List<Lotto> lottos = new ArrayList<>();

    private WinningNumber userInputWinningNumber;

    private WinningStatistic result;

    public void play() {
        init();

        buyLottoPhase();
        inputWinningNumberPhase();
        resultPhase();
    }

    private void init() {
        this.userInputPurchaseAmount = null;
        this.userInputManualLottoCount = null;
        this.totalLottoCount = null;
        this.autoLottoCount = null;

        this.lottos.clear();

        this.userInputWinningNumber = null;
        this.result = null;
    }

    private void buyLottoPhase() {
        this.userInputPurchaseAmount = new LottoPurchaseAmount(intAsk("구입 금액을 입력해 주세요."));
        this.totalLottoCount = this.userInputPurchaseAmount.calTotalLottoCount();

        this.userInputManualLottoCount = new LottoCount(intAsk("수동으로 구매할 로또 개수를 입력해 주세요."));
        this.autoLottoCount = this.totalLottoCount.subtractionBy(this.userInputManualLottoCount);

        buyManualLottoPhase();

        Renderer.simplePrint("나머지는 자동으로 구매합니다.");
        buyAutoLottoPhase();

        Renderer.simplePrint("수동으로 " + this.userInputManualLottoCount + "장, 자동으로 " + this.autoLottoCount + "장 구매했습니다.");
        Renderer.printLottos(this.lottos);
    }

    private void buyAutoLottoPhase() {
        this.lottos.addAll(
                LottoGenerator.generateRandomLotto(this.autoLottoCount.toInt())
        );
    }

    private void buyManualLottoPhase() {
        Renderer.simplePrint("수동으로 구매할 로또의 번호를 입력해 주세요.");
        for (int i = 1; i <= this.userInputManualLottoCount.toInt(); i++) {
            List<Integer> userInputLottoNumber = Question.intListAsk("로또 " + i + "장 째: ");
            Lotto lotto = Lotto.of(userInputLottoNumber);
            lottos.add(lotto);
        }
    }

    private void inputWinningNumberPhase() {
        List<Integer> userInputWinningNumber = Question.intListAsk("지난 주 당첨 번호를 입력해 주세요.");
        int userInputBonusNumber = intAsk("보너스 볼을 입력해 주세요.");

        this.userInputWinningNumber = WinningNumber.of(userInputWinningNumber, userInputBonusNumber);
    }

    private void resultPhase() {
        WinningStatistic result = new WinningStatistic();

        for (Lotto myLotto : this.lottos) {
            WinningLevel rank = WinningLevel.decideFinalWinningLevel(myLotto, this.userInputWinningNumber);

            result.occurs(rank);
        }

        Renderer.printResult(result);
        Renderer.printRatio(
                Ratio.ratio(
                        result.getTotalWinAmount().toInt(), this.userInputPurchaseAmount.toInt()
                )
        );
    }
}
