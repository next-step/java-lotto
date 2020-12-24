package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printMessage("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        long amount = scanner.nextLong();
        int lottoCount = LotteryMachine.calculateLottoCount(amount);
        outputView.printLottoCount(lottoCount);

        Lottos lottos = LotteryMachine.issueAutomaticLotto(lottoCount);
        outputView.printLottos(lottos);

        outputView.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        List<LottoNumber> lottoNumbers = inputView.inputLuckyNumbers(scanner.nextLine());
        Lotto luckyLotto = new Lotto(lottoNumbers);
        lottos.drawLottos(luckyLotto);
        outputView.printMessage("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        LottoNumber bonusNumber = new LottoNumber(scanner.nextInt());

        LottoStatistic lottoStatistic = lottos.makeStatistic(bonusNumber);
        outputView.printStatistic(lottoStatistic);

        Profit profit = new Profit(lottoStatistic.calculateProfit(amount));
        outputView.printProfit(profit);

    }

}
