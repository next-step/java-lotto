package study.lotto.domain;

import study.lotto.util.LottoNumberGenerator;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        WinningNumbers winningNumbers = inputWinninNumbers();
        WinningResult winningResult = checkPrize(purchasedLottos, winningNumbers);
        printResult(purchaseAmount, winningResult);
    }

    private WinningNumbers inputWinninNumbers() {
        LottoNumbers winningNumbers = new LottoNumbers(LottoNumberGenerator.markedNumbers(inputView.inputWinningNumbers()));
        LottoNumber bonusNumber = inputView.inputBonusNumber();
        validateBonusNumber(winningNumbers, bonusNumber);
        return new WinningNumbers(winningNumbers, bonusNumber);

    }

    public void validateBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.lottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int purchaseableNumber(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE,0, RoundingMode.DOWN).intValue();
    }

    public PurchasedLottos purchase(BigDecimal purchaseAmount) {
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchaseableNumber(purchaseAmount));
        resultView.purchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    public WinningResult checkPrize(PurchasedLottos purchasedLottos, WinningNumbers winningNumbers) {
        WinningResult winningResult = new WinningResult();
        for (LottoNumbers lottoNumbers : purchasedLottos.values()) {
            int matchCount = lottoNumbers.matchWinningNumberCount(winningNumbers.lottoNumbers());
            boolean matchBonus = lottoNumbers.isMatchBonus(winningNumbers.bonusNumber());
            winningResult.addPrize(matchCount, matchBonus);
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
