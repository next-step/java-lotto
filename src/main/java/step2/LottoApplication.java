package step2;

import step2.view.InputView;
import step2.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        String money = InputView.inputMoney();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoStore lottoStore = new LottoStore(money, randomNumberGenerator);
        InputView.printLottoList(lottoStore);

        String winNumbers = InputView.inputWinnerNumbers();
        LottoNumbers winnerNumbers = new LottoNumbers(winNumbers);

        LotteryAwardSystem lotteryAwardSystem = new LotteryAwardSystem(lottoStore.getLottos(), winnerNumbers, lottoStore.getBuyMoney());
        ResultView.printResult(lotteryAwardSystem);
    }
}
