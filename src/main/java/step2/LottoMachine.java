package step2;

import java.util.List;
import java.util.Scanner;

public class LottoMachine {

    private List<Lotto> lottos;
    private LottoPrice lottoPrice;

    public LottoMachine() {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            makeLotto(inputView.askPurchaseAmount());
            ResultView.showLottoUnitCount(lottos.size());
            ResultView.showLottoUnitDetail(lottos);
            Lotto lastWeekWinningLotto = new Lotto(inputView.askLastWeekWinningNumber());
            ResultView.showWinningStats(lottos, lastWeekWinningLotto, lottoPrice);
        }
    }

    private void makeLotto(String askPurchaseAmount) {
        this.lottoPrice = new LottoPrice(askPurchaseAmount);
        this.lottos = LottoGenerator.publish(lottoPrice.getAvailableForPurchaseCount());
    }

    public static void main(String[] args) {
        new LottoMachine();
    }
}
