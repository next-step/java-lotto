package lotto.model.domain;

public class LottosSize {

    private final long totalSize;
    private final long manualSize;
    private final long automaticSize;

    private LottosSize(final long totalSize, final long manualSize) {
        this.totalSize = totalSize;
        this.manualSize = manualSize;
        this.automaticSize = totalSize - manualSize;
    }

    public static LottosSize of(final LottoMoney totalMoney, final long manualSize) {
        return new LottosSize(totalMoney.size(Lotto.SIZE), manualSize);
    }
}
