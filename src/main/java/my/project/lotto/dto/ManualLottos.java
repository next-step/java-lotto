package my.project.lotto.dto;

import my.project.lotto.domain.Lotto;

import java.util.List;

/**
 * Created : 2020-11-30 오전 9:30
 * Developer : Seo
 */
public class ManualLottos {
    private final List<Lotto> manualLottos;

    public ManualLottos(List<Lotto> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public int size() {
        return this.manualLottos.size();
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }
}
