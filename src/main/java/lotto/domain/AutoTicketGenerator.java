package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoTicketGenerator {
    private static final List<LottoNumber> candidates = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            candidates.add(LottoNumber.of(i));
        }
    }

    public static LottoTicket generate() {
        List<LottoNumber> copy = new ArrayList<>(candidates);
        Collections.shuffle(copy);
        return new LottoTicket(copy.subList(0, LottoTicket.NUMBER_LENGTH));
    }
}
