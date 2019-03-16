package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMarket;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        doLottery();
    }

    private static void doLottery() {
        try {
            int buyCount = LottoView.buyLotto();

            List<Lotto> lottos = new ArrayList<>();

            for (int i = 0; i < buyCount; i++) {
                Lotto lotto = new Lotto(LottoMarket.createNumbers());
                lottos.add(lotto);
            }

            LottoView.showBuyLottos(lottos);

            String[] splitWinningNumbers = LottoView.splitWinningNumbers(LottoView.inputWinningNumbers());
            List<Integer> winningNumbers = LottoMachine.createWinningNumbers(splitWinningNumbers);

            for (int number : winningNumbers) {
                LottoMachine.checkWinning(lottos, number);
            }

            LottoView.showWinningStatistics(lottos);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
