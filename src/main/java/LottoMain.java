import lotto.domain.*;
import lotto.model.request.ReqAutoLotto;
import lotto.service.LottoMachine;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money money = InputView.inputPrice();

        Lotto lotto = LottoMachine.issueLotto(new AutoLottoNumbersGenerator(), new ReqAutoLotto(money));
        OutputView.printLottoQuantity(lotto);
        OutputView.printLottoList(lotto);

        LottoNumbers winnerLottoNumber = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber(winnerLottoNumber);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumber, bonusNumber);

        Statistics statistics = new Statistics(winnerLotto, lotto, money);

        OutputView.printStatisticsResult(statistics);
        OutputView.printProfit(statistics);
    }
}
