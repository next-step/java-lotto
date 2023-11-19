package study.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import study.step2.domain.*;
import study.step2.domain.dto.PurchaseAmount;
import study.step2.domain.dto.Result;

import static study.step2.view.InputView.inputPurchaseAmount;
import static study.step2.view.InputView.inputWinningNumbers;
import static study.step2.view.ResultView.*;

public class Step2Application {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        int numberOfLottos = purchaseAmount.numberOfLottos();
        show(numberOfLottos);

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generator.generate());
        }
        show(lottos);

        WinningNumbers winningNumbers = inputWinningNumbers();
        List<Rank> ranks = lottos.stream()
            .map(lotto -> lotto.matches(winningNumbers.toIntegers()))
            .collect(Collectors.toList());

        Result result = new Result();
        ranks.forEach(result::add);

        showStatisticsTitle();

        result.map().keySet().stream()
            .filter(Rank::isHit)
            .forEach(rank -> showStatistics(rank, result.size(rank)));

        int totalWinningAmount = result.totalWiningAmount();
        showRevenue(result.toRevenue(totalWinningAmount, purchaseAmount.amount()));
    }

}
