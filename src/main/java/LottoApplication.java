import domain.Lotto;
import domain.LottoNumbers;
import domain.LottoMatch;
import util.Calculator;
import util.Console;
import util.Generator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        if (money == 0) {
            return;
        }
        int lottoCount = ResultView.purchaseLottoCount(money);

        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount-- > 0) {
            Lotto lotto = new Lotto(new LottoNumbers(Generator.lottoNumbers()));
            lottos.add(lotto);
            ResultView.printLotto(lotto);
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        if (winningNumbers.isEmpty()) {
            return;
        }

        int bonusBall = InputView.inputBonusBall();
        if (bonusBall == 0) {
            return;
        }
        if (winningNumbers.contains(bonusBall)) {
            Console.print("당첨번호와 보너스볼 숫자가 같을 수 없습니다.");
            return;
        }
        winningNumbers.add(bonusBall);

        LottoMatch lottoMatch = new LottoMatch(lottos, winningNumbers);
        ResultView.statisticsWinner(lottoMatch.produceResult());
        ResultView.printYield(Calculator.yieldCalculator(lottoMatch.produceResult(), money));
    }
}
