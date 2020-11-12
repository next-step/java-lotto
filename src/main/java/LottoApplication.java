import domain.LottoCalculator;
import domain.Lottos;
import domain.Money;
import ui.InputView;
import ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) throws Exception {
        int buyingAmount = InputView.askMoneyAmount();
        LottoCalculator lottoCalculator= new LottoCalculator(new Money(buyingAmount));

        Lottos lottos = lottoCalculator.getLottos();

        ResultView.print(lottos);
    }
}
