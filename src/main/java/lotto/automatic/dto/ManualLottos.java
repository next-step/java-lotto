package lotto.automatic.dto;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.Lottos;

import java.util.List;

public class ManualLottos {

    private final Lottos lottos;
    private final int manualAmount;

    public ManualLottos(int manualAmount, List<String> stringInputs) {
        validateManualAmount(manualAmount);

        Lottos lottos = new Lottos();

        for(String rawInput : stringInputs) {
            lottos.append(Lotto.manual(rawInput));
        }

        this.manualAmount = manualAmount;
        this.lottos = lottos;
    }

    public static void validateManualLottoCountWithTotalCount(int totalAmount, int manualAmount) {

        if(manualAmount > totalAmount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 전체 로또 수 보다 작아야 합니다.");
        }
    }

    public Lottos getLottos() {
        return lottos;
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
