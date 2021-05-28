package study.lotto.domain;

import study.lotto.util.LottoNumberGenerator;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public static final int MARK_SIZE = 6;
    public static final List<Integer> AVAILABLE_LOTTONUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        BigDecimal purchaseAmount = inputView.inputPurchaseAmount();
        PurchasedLottos purchasedLottos = purchase(purchaseAmount);
        LottoNumbers winningNumbers = new LottoNumbers(LottoNumberGenerator.markedNumbers(inputView.inputWinningNumbers()));
        WinningResult winningResult = checkPrize(purchasedLottos, winningNumbers);
        printResult(purchaseAmount, winningResult);
    }

    public int purchaseableNumber(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE,0, RoundingMode.DOWN).intValue();
    }

    public PurchasedLottos purchase(BigDecimal purchaseAmount) {
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchaseableNumber(purchaseAmount));
        resultView.purchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    public WinningResult checkPrize(PurchasedLottos purchasedLottos, LottoNumbers winningNumbers) {
        WinningResult winningResult = new WinningResult();
        for (LottoNumbers lottoNumbers : purchasedLottos.values()) {
            int matchCount = lottoNumbers.matchWinningNumberCount(winningNumbers);
            winningResult.addPrize(matchCount);
        }

        return winningResult;
    }

    public BigDecimal profitRate(BigDecimal purchaseAmount, BigDecimal prizeAmount) {
        return prizeAmount.divide(purchaseAmount.divide(LOTTO_PRICE, 0, RoundingMode.FLOOR),2, RoundingMode.HALF_UP);
    }

    public void printResult(BigDecimal purchaseAmount, WinningResult winningResult) {
        BigDecimal profitRate = profitRate(purchaseAmount, winningResult.totalPrize());
        resultView.winningResult(winningResult,profitRate);
    }

}
