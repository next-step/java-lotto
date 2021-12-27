package step2;

import java.util.List;
import java.util.Scanner;

public class LottoMachine {

    public LottoMachine() {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);

            LottoPrice lottoPrice = new LottoPrice(inputView.askPurchaseAmount());
            List<Lotto> lottos = LottoGenerator.publish(lottoPrice.getAvailableForPurchaseCount());

            ResultView.showLottoUnitCount(lottos.size());
            ResultView.showLottoUnitDetail(lottos);

            Lotto lastWeekWinningLotto = new Lotto(inputView.askLastWeekWinningNumber());
            ResultView.showWinningStats(lottos, lastWeekWinningLotto, lottoPrice);
        }
    }

    public static void main(String[] args) {
        new LottoMachine();
    }
}
