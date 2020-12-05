package lotto.automatic.dto;

import java.util.List;

public class ManualLottos {

    private final int manualAmount;
    private List<String> rawStrings;

    public ManualLottos(int manualAmount, List<String> rawStrings) {
        validateManualAmount(manualAmount);

        this.manualAmount = manualAmount;
        this.rawStrings = rawStrings;
    }

    public static void validateManualLottoCountWithTotalCount(int totalAmount, int manualAmount) {

        if(manualAmount > totalAmount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 전체 로또 수 보다 작아야 합니다.");
        }
    }

    public List<String> getRawStrings() {
        return rawStrings;
    }

    private void validateManualAmount(int manualAmount) {
        if ( manualAmount < 0 ) {
            throw new IllegalArgumentException("올바른 수동 구매 수를 입력해주세요.");
        }
    }

    public int getManualAmount() {

        return manualAmount;
    }
}
