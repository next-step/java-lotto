package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private int autoAmount;
//    private int manualCount;
    private Lottos manualLottos;
    private Lottos autoLottos;
    private WinningLotto winningLotto;

    public LottoGame(int autoAmount, WinningLotto winningLotto) {
        this.autoAmount = autoAmount;
        this.winningLotto = winningLotto;
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

    public int getAutoCount() {
        return this.autoAmount / Lottos.LOTTO_PRICE;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
