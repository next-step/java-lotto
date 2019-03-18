package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private int lottosCount;
    private List<Lotto> lottos;

    public LottoTicket(final int lottosCount) {
        if (lottosCount < 1) {
            throw new IllegalArgumentException();
        }

        this.lottosCount = lottosCount;
        this.lottos = new ArrayList<>(this.lottosCount);
    }

    public List<Lotto> publish() {
        for (int i = 0; i < this.lottosCount; i++) {
            this.lottos.add(new Lotto());
        }

        return this.lottos;
    }

    public int getLottosCount() {
        return lottosCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
