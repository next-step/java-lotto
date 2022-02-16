package lotto.domain;

public class ManualLottoCount {

    private static final int MAX_MANUAL_LOTTO_COUNT = 10;

    private final int manualLottoCount;

    private ManualLottoCount(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;

        validateRange();
    }

    public static ManualLottoCount from(int manualLottoCount) {
        return new ManualLottoCount(manualLottoCount);
    }

    public int getCount() {
        return manualLottoCount;
    }

    private void validateRange() {
        if (!isInRange()) {
            throw new IllegalArgumentException("[ERROR] 가능한 수동 입력 로또 개수는 0 이상 10 미만입니다.");
        }
    }

    private boolean isInRange() {
        return manualLottoCount >= 0 && manualLottoCount < MAX_MANUAL_LOTTO_COUNT;
    }
}
