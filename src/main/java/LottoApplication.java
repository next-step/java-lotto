import domain.Lotto;
import domain.LottoNumbes;
import domain.LottoMatch;
import util.Calculator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int lottoCount = ResultView.purchaseLottoCount(money);

        List<Lotto> lottos = new ArrayList<>();
        while (lottoCount-- > 0) {
            Lotto lotto = new Lotto(new LottoNumbes().lottoNumber);
            lottos.add(lotto);
            ResultView.printLotto(lotto.getLotto());
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        if (winningNumbers.isEmpty()) {
            return;
        }

        LottoMatch lottoMatch = new LottoMatch(lottos, winningNumbers);
        ResultView.statisticsWinner(lottoMatch.produceResult());
        ResultView.printYield(Calculator.yieldCalculator(lottoMatch.produceResult(), money));
    }
}
