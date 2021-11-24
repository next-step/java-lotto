package edu.nextstep.camp.lotto;

import java.util.Collection;
import java.util.stream.Collectors;

import edu.nextstep.camp.lotto.domain.AutoLottoGenerator;
import edu.nextstep.camp.lotto.domain.GameResult;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoNumber;
import edu.nextstep.camp.lotto.domain.PurchaseList;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.OutputView;

public class LottoStore {
    public static void main(String[] args) {
        int budget = InputView.inputBudget();
        final PurchaseList purchaseList = PurchaseList.purchase(budget, AutoLottoGenerator.getInstance());
        OutputView.printPurchasedLotto(purchaseList);

        Collection<LottoNumber> winningNumbers = InputView.inputWinningNumber()
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        final GameResult gameResult = purchaseList.winningResult(Lotto.of(winningNumbers));
        OutputView.printGameResult(gameResult);
        OutputView.printPriceEarningRate(purchaseList.priceEarningRate(gameResult));
    }
}
