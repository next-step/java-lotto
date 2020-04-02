package lotto.model.wrapper;

public class ManualLottoCount {

    private final int count;

    private ManualLottoCount(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("수동으로 구입할 로또 갯수는 0 이상이어야 합니다.");
        }
        this.count = count;
    }

    public static ManualLottoCount of(final int count) {
        return new ManualLottoCount(count);
    }

    public int getCount() {
        return count;
    }
}
