package lotto.model;

public class Count {
    private static final String PRICE_CANNOT_BE_NEGATIVE ="로또의 개수는 음수가 될 수 없습니다.";
    private final int autoLottoCount;
    private final int manualLottoCount;

    public Count(int totalLottoCount, int manualLottoCount) {
        validateCount(manualLottoCount);
        this.autoLottoCount = totalLottoCount-manualLottoCount;
        this.manualLottoCount = manualLottoCount;
    }
    private void validateCount(int manualLottoCount){
        if(manualLottoCount<0){
            throw new IllegalArgumentException(PRICE_CANNOT_BE_NEGATIVE);
        }
    }
    public int getCount() {
        return autoLottoCount + manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
