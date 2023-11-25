package step4.model;

public class LottoCount {

    private int count;

    public LottoCount(int count) {
        this.count = count;
    }

    public LottoCount() {
    }

    public int getCount() {
        return this.count;
    }

    public LottoCount autoLottoCount(int allLottoCount, int manualLottoCount) {
        isPositive(manualLottoCount);
        int autoLottoCount = allLottoCount - manualLottoCount;
        if (autoLottoCount < 0) {
            throw new IllegalArgumentException("지불한 금액보다 로또 수량이 더 많습니다.");
        }

        return new LottoCount(autoLottoCount);
    }

    public void isPositive(int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
