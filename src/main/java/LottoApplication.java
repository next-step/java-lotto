import model.LottoMachine;
import model.LottoNumberGenerator;
import model.RandomLottoNumberGenerateImpl;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.getPaidMoney();
        ResultView.printNumberOfLotto(money, LottoMachine.PRICE_OF_A_LOTTO);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(new RandomLottoNumberGenerateImpl());
        List<List<Integer>> lottoNumbers = lottoNumberGenerator.run(money, LottoMachine.PRICE_OF_A_LOTTO);
        ResultView.printLottoNumbers(lottoNumbers);

        List<Integer> winningNumbers = InputView.getWinningNumbers();

        LottoMachine lottoMachine = new LottoMachine(
                winningNumbers,
                money,
                lottoNumbers
        );

        ResultView.printLottoStatistics(lottoMachine.getStatistics());
    }
}
