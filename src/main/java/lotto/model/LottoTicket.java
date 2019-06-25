package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}