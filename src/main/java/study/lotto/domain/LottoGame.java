package study.lotto.domain;

import study.lotto.exception.DuplicateBonusBallException;
import study.lotto.exception.WrongSelfPickCountException;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int MARK_SIZE = 6;
    public static final int LOTTONUMBER_FROM = 1;
    public static final int LOTTONUMBER_TO = 45;

    public static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        BigDecimal purchaseAmount = inputView.inputPurchaseAmount();
        PurchasedLottos purchasedLottos = purchase(purchaseableNumber(purchaseAmount));
        WinningNumbers winningNumbers = inputWinninNumbers();
        WinningResult winningResult = checkPrize(purchasedLottos, winningNumbers);
        printResult(purchaseAmount, winningResult);
    }

    public int purchaseableNumber(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE,0, RoundingMode.DOWN).intValue();
    }

    private WinningNumbers inputWinninNumbers() {
        Lotto winningNumbers = new Lotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = inputView.inputBonusNumber();
        validateBonusNumber(winningNumbers, bonusNumber);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public void validateBonusNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.lotto().contains(bonusNumber)) {
            throw new DuplicateBonusBallException();
        }
    }

    public PurchasedLottos purchase(int count) {
        PurchasedLottos purchasedLottos = selfPick(count);
        int selfPickCount = purchasedLottos.count();
        PurchasedLottos randomPick = new PurchasedLottos(count - selfPickCount);
        resultView.purchasedLottos(selfPickCount, randomPick);
        purchasedLottos.add(randomPick.values());

        return purchasedLottos;
    }

    public PurchasedLottos selfPick(int count) {
        int selfPickLottoCount = inputView.inputSelfPickLottoCount();
        validateSelfPickCount(count, selfPickLottoCount);
        if (selfPickLottoCount < 1) {
            return new PurchasedLottos();
        }
        List<String> selfPickLottoList = inputView.inputSelfPickLotto(selfPickLottoCount);
        return new PurchasedLottos(selfPickLottoList.stream().map(Lotto::new).collect(Collectors.toList()));
    }

    private void validateSelfPickCount(int count, int selfPickLottoCount) {
        if (count < selfPickLottoCount) {
            throw new WrongSelfPickCountException();
        }
    }

    public WinningResult checkPrize(PurchasedLottos purchasedLottos, WinningNumbers winningNumbers) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : purchasedLottos.values()) {
            int matchCount = lotto.matchWinningNumberCount(winningNumbers.lottoNumbers());
            boolean matchBonus = lotto.isMatchBonus(winningNumbers.bonusNumber());
            winningResult.addPrize(matchCount, matchBonus);
        }

        return winningResult;
    }

    public BigDecimal profitRate(BigDecimal purchaseAmount, BigDecimal prizeAmount) {
        return prizeAmount.divide(purchaseAmount,2, RoundingMode.HALF_UP);
    }

    public void printResult(BigDecimal purchaseAmount, WinningResult winningResult) {
        BigDecimal profitRate = profitRate(purchaseAmount, winningResult.totalPrize());
        resultView.winningResult(winningResult,profitRate);
    }

}
