package lotto;

import lotto.domain.Customer;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultAnalyzer;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();

        int purchaseAmount = InputView.getPurchaseAmount();
        customer.purchaseLottos(purchaseAmount);

        OutputView.printLottos(customer.getLottos());

        List<LottoNumber> winningNumbers = InputView.getWinningNumbers();
        customer.checkLottosResult(winningNumbers);

        Map<Rank, Integer> statistics = LottoResultAnalyzer.generateStatistics(customer);
        OutputView.printStatistics(statistics);

        double ROI = LottoResultAnalyzer.getROI(customer);
        OutputView.printROI(ROI);
    }
}
