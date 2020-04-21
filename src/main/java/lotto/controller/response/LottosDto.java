package lotto.controller.response;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Set;

public class LottosDto {
    private Set<Lotto> manualLottos;
    private Set<Lotto> autoLottos;

    private LottosDto(Set<Lotto> manualLottos, Set<Lotto> autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public static LottosDto getInstance(Lottos manualLottos, Lottos autoLottos) {
        return new LottosDto(manualLottos.getLottos(), autoLottos.getLottos());
    }

    public Set<Lotto> getManualLottos() {
        return manualLottos;
    }

    public void setManualLottos(Set<Lotto> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public Set<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public void setAutoLottos(Set<Lotto> autoLottos) {
        this.autoLottos = autoLottos;
    }

    public int manualLottoCount() {
        return manualLottos.size();
    }

    public int autoLottoCount() {
        return autoLottos.size();
    }
}
