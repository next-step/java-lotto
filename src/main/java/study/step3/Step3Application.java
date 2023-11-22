package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import study.step3.domain.*;
import study.step3.domain.dto.*;

import static study.step3.view.InputView.*;
import static study.step3.view.ResultView.*;

public class Step3Application {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        int purchaseCount = purchaseAmount.purchaseCount();

        LottoCount manualCount = inputManualLottoCount();
        LottoCount autoCount = manualCount.calculateAutoLottoCount(purchaseCount);

        List<Lotto> manualLottos = inputManualLottoNumbers(manualCount);
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        show(manualCount, autoCount);

        LottoGenerator generator = new LottoGenerator();
        for (int i = 0; i < autoCount.count(); i++) {
            lottos.add(generator.generate());
        }
        show(lottos);

        Lotto winningNumbers = inputWinningNumbers();
        LottoNumber bonusNumber = inputBonusNumber();

        List<Rank> ranks = lottos.stream()
            .map(lotto -> lotto.matches(winningNumbers, bonusNumber))
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
