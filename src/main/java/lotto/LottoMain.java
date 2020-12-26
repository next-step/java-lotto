package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printMessage("구입금액을 입력해 주세요.");
        long amount = inputView.inputPurchaseAmount();
        int lottoCount = LotteryMachine.calculateLottoCount(amount);
        outputView.printLottoCount(lottoCount);

        Lottos lottos = LotteryMachine.issueAutomaticLotto(lottoCount);
        outputView.printLottos(lottos);

        outputView.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> lottoNumbers = inputView.inputLuckyNumbers();
        Lotto luckyLotto = new Lotto(lottoNumbers);
        //lottos.drawLottos(luckyLotto);
        outputView.printMessage("보너스 볼을 입력해 주세요.");
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());

        LottoStatistic lottoStatistic = lottos.makeStatistic(luckyLotto, bonusNumber);
        outputView.printStatistic(lottoStatistic);

        Profit profit = new Profit(lottoStatistic.calculateProfit(amount));
        outputView.printProfit(profit);

    }

}
