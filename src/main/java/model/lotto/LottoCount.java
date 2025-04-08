package model.lotto;

public class LottoCount {
    private final int manualLottoCount;
    private final int autoLottoCount;
    private final int totalCount;

    public LottoCount(int totalCount, int manualLottoCount){
        this.totalCount = totalCount;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalCount - manualLottoCount;
        checkValidLottoCounts();
    }

    private void checkValidLottoCounts(){
        if(manualLottoCount > totalCount) {
            throw new IllegalArgumentException("발급 가능한 수를 초과했습니다.");
        }
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount(){
        return autoLottoCount;
    }
}
