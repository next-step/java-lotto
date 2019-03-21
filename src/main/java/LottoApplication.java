import domain.Lotto;
import domain.LottoNumber;
import domain.Lottos;
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
            Lotto lotto = new Lotto(new LottoNumber().lottoNumber);
            lottos.add(lotto);
            ResultView.printLotto(lotto.getLotto());
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        if (winningNumbers == null) {
            return;
        }

        Lottos lottoDomain = new Lottos(lottos, winningNumbers);
        ResultView.statisticsWinner(lottoDomain.produceResults());
        ResultView.printYield(Calculator.yieldCalculator(lottoDomain.produceResults(), money));
    }
}
