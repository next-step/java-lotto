package lotto.domain;

public class LottoBuyer {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private Lottos lottos;

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLottos() {
        lottos = LottoStore.createLottos(lottoCount());
    }

    private int lottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void confirmLottos(WinningNumbers lastWinningNumbers) {
        lottos.confirmAll(lastWinningNumbers);
    }

    public double calculateProfitRate() {
        return (double) lottos.calculateTotalWinPrice() / (double) purchaseAmount;
    }

    public Lottos lottos() {
        return lottos;
    }
}
