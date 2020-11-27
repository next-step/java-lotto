package step4.lotto.domain.numbers;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoTicket {
    private final SortedSet<Integer> lottoTicket;

    LottoTicket(final List<Integer> lotto) {
        LottoNumber lottoNumber = new LottoNumber(lotto);
        this.lottoTicket = new TreeSet<>(lottoNumber.getLottoNumber());
    }

    public SortedSet<Integer> getLottoTicket() {
        return lottoTicket;
    }
}
