package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Ticket;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public BasicLotto generate() {
        return new BasicLotto(new Ticket(null));
    }

    @Override
    public BasicLotto generate(Ticket ticket) {
        return new BasicLotto(ticket);
    }
}
