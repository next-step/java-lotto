package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Lotto> manualLottos = null;
    private List<Lotto> autoLottos = null;

    public LottoTicket(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public List<Lotto> getManualLottos() {
        return Collections.unmodifiableList(manualLottos);
    }

    public List<Lotto> getAutoLottos() {
        return Collections.unmodifiableList(autoLottos);
    }

    public int getManualLottoCount() {
        return this.manualLottos.size();
    }

    public int getAutoLottoCount() {
        return this.autoLottos.size();
    }
}
