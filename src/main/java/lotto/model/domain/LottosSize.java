package lotto.model.domain;

public final class LottosSize {

    private final long manualSize;
    private final long automaticSize;

    private LottosSize(final long totalSize, final long manualSize) {
        validate(totalSize, manualSize);

        this.manualSize = manualSize;
        this.automaticSize = totalSize - manualSize;
    }

    public static LottosSize of(final LottoMoney totalMoney, final long manualSize) {
        return new LottosSize(totalMoney.sizeOfLottos(Lotto.COST), manualSize);
    }

    private void validate(final long totalSize, final long manualSize) {
        validateTotalSize(totalSize);
        validateManualSize(manualSize, totalSize);
    }

    private void validateTotalSize(final long totalSize) {
        if (totalSize <= 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. 구입금액이 부족합니다. 로또는 한 장에 " + Lotto.COST + "원 입니다.");
        }
    }

    private void validateManualSize(final long manualSize, final long totalSize) {
        if (manualSize < 0) {
            throw new IllegalArgumentException("로또 개수는 음수가 될 수 없습니다. 입력한 수동 로또 개수: " + manualSize);
        }

        if (manualSize > totalSize) {
            throw new IllegalArgumentException("전체 로또 개수(" + totalSize + "개)보다 수동 로또 개수(" + manualSize + "개)가 더 많습니다.");
        }
    }

    public long getManualSize() {
        return manualSize;
    }

    public long getAutomaticSize() {
        return automaticSize;
    }
}
