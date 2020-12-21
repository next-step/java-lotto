package lotto;

import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Scanner;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printMessage("구입금액을 입력해 주세요.");
        int amount = inputView.inputAmount(new Scanner(System.in));
        int lottoCount = LotteryMachine.calculateLottoCount(amount);
        outputView.printLottoCount(lottoCount);

        Lottos lottos = LotteryMachine.issueAutomaticLotto(lottoCount);
        outputView.printLottos(lottos);

        outputView.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        Integer[] luckyNumbers = inputView.inputLuckyNumbers(new Scanner(System.in));
        Lotto luckyLotto = new Lotto(luckyNumbers);

        lottos.drawAutomaticLottos(luckyLotto);
        LottoStatistic lottoStatistic = lottos.makeStatistic();
        lottoStatistic.calculateProfit(amount);

        outputView.printStatistic(lottoStatistic);

    }

}
