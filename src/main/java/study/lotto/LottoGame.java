package study.lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    private WinningNumbers winningNumbers;
    private WinningLottos winningLottos;
    private PurchasedLotto purchasedLotto;

    public LottoGame() {
        this.winningLottos = new WinningLottos();
    }

    public LottoGame(WinningNumbers winningNumbers, PurchasedLotto purchasedLotto) {
        this.winningNumbers = winningNumbers;
        this.winningLottos = new WinningLottos();
        this.purchasedLotto = purchasedLotto;
    }

    public int purchaseableLotto(BigDecimal amount){
        return amount.divide(lottoPrice).intValue();
    }

    public void purchase(BigDecimal amount) {
       this.purchasedLotto = new PurchasedLotto(purchaseableLotto(amount));
    }

    public PurchasedLotto purchasedLotto(){
        return purchasedLotto;
    }

    public void draw() {
        this.winningNumbers = new WinningNumbers();
    }

    public WinningNumbers winningNumbers() {
        return winningNumbers;
    }

    public void checkPrize(){
        for (LottoPaper lottoPaper : purchasedLotto.values()) {
            winningLottos.add(lottoPaper.checkPrize(winningNumbers));
        }
    }

    public WinningLottos winningLottos(){
        return winningLottos;
    }
}
