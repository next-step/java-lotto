import lotto.Lotto;
import lotto.LottoFactory;
import lotto.LottoMoney;
import lotto.LottoResults;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int totalLottoAmount = InputView.getLottoAmounts();
        LottoMoney lottoMoney = LottoMoney.of(totalLottoAmount);

        LottoFactory lottoFactory = new LottoFactory(lottoMoney);
        ResultView.printLottoCounts(lottoFactory.getLottoCounts());

        List<Lotto> lottos = lottoFactory.createLottos();
        ResultView.printLottos(lottos);

        String lotteryNumbersString = InputView.getLotteryNumbersString();

        LottoResults lottoResults = new LottoResults(lotteryNumbersString, lottos);
        ResultView.printLottoResults(lottoResults);
    }
}
