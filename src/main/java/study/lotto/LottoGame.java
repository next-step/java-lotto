package study.lotto;

import java.math.BigDecimal;

public class LottoGame {
    private static final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    private WinningNumbers winningNumbers;

    public LottoGame() {
    }

    public int purchaseableLotto(BigDecimal amount){
        return amount.divide(lottoPrice).intValue();
    }

    public PurchasedLotto purchase(BigDecimal amount) {
       return new PurchasedLotto(purchaseableLotto(amount));
    }

    public void draw() {
        this.winningNumbers = new WinningNumbers();
    }

    public WinningNumbers winningNumbers() {
        return winningNumbers;
    }
}
