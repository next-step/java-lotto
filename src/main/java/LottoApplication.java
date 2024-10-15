import model.LottoMachine;
import model.LottoNumberGenerator;
import model.RandomLottoNumberGenerateImpl;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.getPaidMoney();

        int countOfManualLottoNumbers = InputView.getCountOfManualLottoNumbers();
        List<List<Integer>> manualLottoNumbers = InputView.getManualLottoNumbers(countOfManualLottoNumbers);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(new RandomLottoNumberGenerateImpl());
        int countOfRandomLottoNumbers = money / LottoMachine.PRICE_OF_A_LOTTO - countOfManualLottoNumbers;
        List<List<Integer>> randomLottoNumbers = lottoNumberGenerator.run(countOfRandomLottoNumbers);

        List<List<Integer>> lottoNumbers = new ArrayList<>(manualLottoNumbers);
        lottoNumbers.addAll(randomLottoNumbers);

        ResultView.printNumberOfLotto(countOfRandomLottoNumbers, countOfManualLottoNumbers);
        ResultView.printLottoNumbers(lottoNumbers);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        Integer bonusNumber = InputView.getBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(
                winningNumbers,
                money,
                lottoNumbers,
                bonusNumber
        );

        ResultView.printLottoStatistics(lottoMachine.getStatistics());
    }
}
