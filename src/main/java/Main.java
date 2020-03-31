import lotto.Controller.LottoController;
import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
import lotto.View.InputView;
import stringPlusCalculate.Controller.MainController;
import stringPlusCalculate.Domain.Calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController(InputView.init(), LottoMachine.init());
        int count = lottoController.payToLotto();
        Lottos lottos = lottoController.buyAutoLotto(count);
        List<Integer> laskweekWinLotto = lottoController.inputLastWeekWinLotto();
        lottoController.LottoResult(lottos, laskweekWinLotto);

    }
}
