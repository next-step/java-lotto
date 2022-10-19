package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private int autoAmount;
    private int manualCount;
    private Lottos manualLottos;
    private Lottos autoLottos;

    public LottoGame(int autoAmount, int manualCount) {
        this.autoAmount = autoAmount;
        this.manualCount = manualCount;
    }

    public void createLottos(List<String> manualNumbers) {
        this.manualLottos = new Lottos().createManualLottos(manualNumbers);
        this.autoLottos = new Lottos().createAutoLottos(autoAmount);
    }

    public Lottos getManualLottos() {
        return this.manualLottos;
    }

    public Lottos getAutoLottos() {
        return this.autoLottos;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getAutoCount() {
        return this.autoAmount / Lottos.LOTTO_PRICE;
    }



}
