import lotto.Lotto;
import lotto.LottoFactory;
import lotto.LottoResults;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int totalLottoAmount = InputView.getLottoAmounts();

        LottoFactory lottoFactory = new LottoFactory(totalLottoAmount);
        ResultView.printLottoCounts(lottoFactory.getLottoCounts());

        List<Lotto> lottos = lottoFactory.createLottos();
        ResultView.printLottos(lottos);

        String lotteryNumbersString = InputView.getLotteryNumbersString();

        LottoResults lottoResults = new LottoResults(lotteryNumbersString, lottos);
        ResultView.printLottoResults(lottoResults);
    }
}
