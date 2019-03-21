package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Ticket;

public interface LottoGenerator {

    BasicLotto generate();

    BasicLotto generate(Ticket ticket);
}
