package step2;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    static final int BASIC_LOTTO_SIZE = 6;

    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Integer> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }
}
