package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class GameRequest {

    private final int paidMoney;
    private final int manualCount;
    private final List<Lotto> manualLottoNumbers;

    public GameRequest(int paidMoney, int manualCount, List<Lotto> manualLottoNumbers) {
        this.paidMoney = paidMoney;
        this.manualCount = manualCount;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<Lotto> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

}
