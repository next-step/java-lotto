package study.lotto;

import java.math.BigDecimal;

public class LottoGame {
    private static final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    private WinningNumbers winningNumbers;
    private WinningLottos winningLottos;
    private PurchasedLottos purchasedLottos;
    private BigDecimal purchaseAmout;

    public LottoGame() {
        this.winningLottos = new WinningLottos();
    }

    public LottoGame(WinningNumbers winningNumbers, PurchasedLottos purchasedLottos) {
        this.winningNumbers = winningNumbers;
        this.winningLottos = new WinningLottos();
        this.purchasedLottos = purchasedLottos;
    }

    public int purchaseableLotto(BigDecimal amount){
        return amount.divide(lottoPrice).intValue();
    }

    public void purchase(BigDecimal amount) {
       int purchaseCount = purchaseableLotto(amount);
       this.purchasedLottos = new PurchasedLottos(purchaseCount);
       this.purchaseAmout = lottoPrice.multiply(BigDecimal.valueOf(purchaseCount));
    }

    public PurchasedLottos purchasedLotto(){
        return purchasedLottos;
    }

    public void draw() {
        this.winningNumbers = new WinningNumbers();
    }

    public void draw(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers winningNumbers() {
        return winningNumbers;
    }

    public void checkPrize(){
        for (LottoPaper lottoPaper : purchasedLottos.values()) {
            winningLottos.add(lottoPaper.checkPrize(winningNumbers));
        }
    }

    public WinningLottos winningLottos(){
        return winningLottos;
    }

    public BigDecimal purchaseAmout(){
        return purchaseAmout;
    }
}
