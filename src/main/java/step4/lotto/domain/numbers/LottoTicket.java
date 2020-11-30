package step4.lotto.domain.numbers;

import step4.lotto.util.CommonLottoCheck;

import java.util.*;

public class LottoTicket {
    private final SortedSet<Integer> lottoTicket;

    LottoTicket(final List<Integer> lotto) {
        CommonLottoCheck.CheckNumber(lotto);
        this.lottoTicket = new TreeSet<>(lotto);
    }

    public SortedSet<Integer> getLottoTicket() {
        return Collections.unmodifiableSortedSet(lottoTicket);
    }

}
