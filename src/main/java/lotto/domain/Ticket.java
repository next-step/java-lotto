package lotto.domain;

import java.util.List;

public class Ticket {
    public final Lottos autoLottos;
    public final Lottos manualLottos;

    public Ticket(Lottos autoLottos, Lottos manualLottos) {
        this.autoLottos = autoLottos;
        this.manualLottos = manualLottos;
    }

    public int autoLottoSize() {
        return 0;
    }

    public int manualSizeSize() {
        return 0;
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        return null;
    }
}
