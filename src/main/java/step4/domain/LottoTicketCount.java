package step4.domain;

public class LottoTicketCount {
    private final int PRICE = 1000;
    private int manualLottoCount;
    private int autoLottoCount;

    public LottoTicketCount(int purchasePrice, int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = purchasePrice / this.PRICE - manualLottoCount;
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }
}
