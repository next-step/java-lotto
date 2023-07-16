package lotto.model.domain;

public final class LottosSize {

    private final long totalSize;
    private final long manualSize;
    private final long automaticSize;

    private LottosSize(final long totalSize, final long manualSize) {
        validateTotalSize(totalSize);

        this.totalSize = totalSize;
        this.manualSize = manualSize;
        this.automaticSize = totalSize - manualSize;
    }

    public static LottosSize of(final LottoMoney totalMoney, final long manualSize) {
        return new LottosSize(totalMoney.size(Lotto.COST), manualSize);
    }

    private void validateTotalSize(final long totalSize) {
        if (totalSize <= 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. 로또는 한 장에 " + Lotto.COST + "원 입니다.");
        }
    }
}
