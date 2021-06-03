package study.lotto.domain;

import study.lotto.exception.DuplicateBonusBallException;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import static study.lotto.domain.PurchaseCount.LOTTO_PRICE;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        BigDecimal purchaseAmount = inputView.inputPurchaseAmount();
        PurchasedLottos purchasedLottos = purchase(new PurchaseCount(purchaseAmount));
        WinningLotto winningLotto = inputWinninLotto();
        WinningResult winningResult = WinningResult.of(purchasedLottos, winningLotto);
        printResult(purchaseAmount, winningResult);
    }

    public int purchaseableNumber(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE,0, RoundingMode.DOWN).intValue();
    }

    private WinningLotto inputWinninLotto() {
        Lotto winningLotto = new Lotto(inputView.inputWinningLotto());
        LottoNumber bonusNumber = inputView.inputBonusNumber();
        validateBonusNumber(winningLotto, bonusNumber);

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new DuplicateBonusBallException();
        }
    }

    public PurchasedLottos purchase(PurchaseCount purchaseCount) {
        PurchasedLottos purchasedLottos = selfPick(purchaseCount);
        PurchasedLottos randomPick = new PurchasedLottos(purchaseCount.availableCount(purchasedLottos.count()));
        resultView.purchasedLottos(purchasedLottos.count(), randomPick);
        purchasedLottos.add(randomPick.values());

        return purchasedLottos;
    }

    public PurchasedLottos selfPick(PurchaseCount purchaseCount) {
        int selfPickLottoCount = inputView.inputSelfPickLottoCount();
        purchaseCount.isAvailable(selfPickLottoCount);
        if (selfPickLottoCount < 1) {
            return new PurchasedLottos();
        }
        List<String> selfPickLottoList = inputView.inputSelfPickLotto(selfPickLottoCount);
        return new PurchasedLottos(selfPickLottoList.stream().map(Lotto::new).collect(Collectors.toList()));
    }

    public BigDecimal profitRate(BigDecimal purchaseAmount, BigDecimal prizeAmount) {
        return prizeAmount.divide(purchaseAmount,2, RoundingMode.HALF_UP);
    }

    public void printResult(BigDecimal purchaseAmount, WinningResult winningResult) {
        BigDecimal profitRate = profitRate(purchaseAmount, winningResult.totalPrize());
        resultView.winningResult(winningResult,profitRate);
    }

}
