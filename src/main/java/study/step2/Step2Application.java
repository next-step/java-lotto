package study.step2;

import java.util.*;
import java.util.stream.Collectors;

import study.step2.domain.*;
import study.step2.domain.dto.*;

import static study.step2.view.InputView.inputPurchaseAmount;
import static study.step2.view.InputView.inputWinningNumbers;
import static study.step2.view.ResultView.*;

public class Step2Application {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        int numberOfLottos = purchaseAmount.numberOfLottos();
        show(numberOfLottos);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            LottoGenerator generator = new LottoGenerator(new Random());
            lottos.add(generator.generate());
        }
        show(lottos);

        WinningNumbers winningNumbers = inputWinningNumbers();
        List<Rank> ranks = lottos.stream()
            .map(lotto -> lotto.matches(winningNumbers))
            .collect(Collectors.toList());

        showStatisticsTitle();
        List<Result> results = Rank.statistics(ranks);
        for (Result result: results) {
            showStatistics(result);
        }

        int winningAmount = Result.sumWinningAmount(results);
        showRevenue(Result.revenue(winningAmount, purchaseAmount.amount()));
    }

}
