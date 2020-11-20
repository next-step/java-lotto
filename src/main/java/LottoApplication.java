import domain.*;
import ui.InputView;
import ui.ResultView;

public class LottoApplication {

    public static void main(String[] args) throws Exception {
        Money buyingAmount = Money.of(InputView.askMoneyAmount());
        Money lottoPrice = Money.of(Lotto.LOTTO_PRICE);
        int numberOfLottos = (int) Math.floor(buyingAmount.dividedBy(lottoPrice));

        Lottos lottos = AutomaticLottoGenerator.generate(numberOfLottos);
        ResultView.printBuyingLottos(lottos);

        Lotto winningLotto = Lotto.of(InputView.askWinningNumbers());
        LottoResult lottoResult = lottos.calculate(winningLotto);
        ResultView.printLottoResult(lottoResult);
    }
}
