package lotto.step4.domain;

import java.util.List;
import java.util.Set;

public class ManualLotto {
    private final int manualLottoCount;
    private final List<Set<Integer>> lottoFromManual;

    public ManualLotto(int manualLottoCount, List<Set<Integer>> lottoFromManual) {
        this.manualLottoCount = manualLottoCount;
        this.lottoFromManual = lottoFromManual;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public List<Set<Integer>> getLottoFromManual() {
        return lottoFromManual;
    }
}
