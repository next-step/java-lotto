package lotto;

import lotto.input.ConsoleWriter;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {

        InputView.purchaseInputView();
        BigDecimal payment = ConsoleWriter.inputBigDecimal();

        Lottos lottos = LottoStore.purchaseLotto(payment);
        InputView.purchaseResultView(lottos);

        InputView.winningInputView();
        List<Integer> winningNumbers = ConsoleWriter.inputIntegerList();

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbers);
        ResultView.statisticsResult(lottoStatistics, payment);


    }
}
