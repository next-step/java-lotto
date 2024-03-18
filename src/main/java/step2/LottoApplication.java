package step2;

import step2.view.InputView;
import step2.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String[] args) {
        String money = InputView.inputMoney();
        LottoStore lottoStore = new LottoStore(money);
        InputView.printLottoList(lottoStore);

        String winNumbers = InputView.inputWinnerNumbers();
        WinnerNumbers winnerNumbers = new WinnerNumbers(winNumbers);

        Lotto winLotto = new Lotto(winnerNumbers.getWinNumbers());
        LotteryAwardSystem lotteryAwardSystem = new LotteryAwardSystem(lottoStore.getLottos(), winLotto, lottoStore.getBuyMoney());
        ResultView.printResult(lotteryAwardSystem);
    }
}
