import domain.AutomaticLottoGenerator;
import domain.LottoResult;
import domain.Lottos;
import domain.Money;
import ui.InputView;
import ui.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) throws Exception {
        Money buyingAmount = Money.of(InputView.askMoneyAmount());
        Money lottoPrice = Money.of(1_000L);
        int numberOfLottos = (int) Math.floor(buyingAmount.dividedBy(lottoPrice));

        Lottos lottos = AutomaticLottoGenerator.generate(numberOfLottos);
        ResultView.printBuyingLottos(lottos);

        List<Integer> winningNumbers = InputView.askWinningNumbers();
        LottoResult lottoResult = lottos.calculate(winningNumbers);
        ResultView.printLottoResult(lottoResult);
    }
}
