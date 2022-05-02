package lotto.domain;

import lotto.util.Calculator;
import lotto.util.SplitUtil;

public class LottoBuyer {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private Lottos lottos;

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLottos() {
        lottos = new LottoStore().createLottos(lottoCount());
    }

    private int lottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void confirmLottos(String winningNumberValue) {
        String[] winningNumbers = SplitUtil.split(winningNumberValue);
        lottos.confirmAll(LottoNumbers.winningLottoNumbers(winningNumbers));
    }

    public double calculateProfitRate() {
        int totalWinPrice = lottos.calculateTotalWinPrice();
        return Double.valueOf(Calculator.divide(totalWinPrice, purchaseAmount));
    }

    public Lottos lottos() {
        return lottos;
    }
}
