package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
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
    
    public static LottoTicketBuilder builder() {
        return new LottoTicketBuilder();
    }

    public static class LottoTicketBuilder {
        private List<Lotto> manualLottos = null;
        private List<Lotto> autoLottos = null;

        LottoTicketBuilder() {}

        public LottoTicketBuilder manualLottos(Collection<? extends Lotto> manualLottos) {
            if (this.manualLottos == null) {
                this.manualLottos = new ArrayList<>();
            }
            if (manualLottos != null) this.manualLottos.addAll(manualLottos);
            return this;
        }

        public LottoTicketBuilder autoLottos(Collection<? extends Lotto> autoLottos) {
            if (this.autoLottos == null) {
                this.autoLottos = new ArrayList<>();
            }
            if (autoLottos != null) this.autoLottos.addAll(autoLottos);
            return this;
        }

        public LottoTicket build() {
            return new LottoTicket(manualLottos, autoLottos);
        }
    }
}
