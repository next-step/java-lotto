package step2;

import step2.view.InputView;
import step2.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        String money = InputView.inputMoney();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoStore lottoStore = new LottoStore(money, randomNumberGenerator, InputView.inputManualNumbers());
        InputView.printLottoList(lottoStore);

        LottoNumbers winnerNumbers = new LottoNumbers(InputView.inputWinnerNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(winnerNumbers, bonusNumber);

        LotteryAwardSystem lotteryAwardSystem = new LotteryAwardSystem(lottoStore.getLottos(), winningNumbers, lottoStore.getBuyMoney());
        ResultView.printResult(lotteryAwardSystem);
    }
}
