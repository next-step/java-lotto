package lotto.domain.strategy;

import java.util.List;

import lotto.domain.LottoTicket;

public interface LottoGenerator {
    List<LottoTicket> generate(int quantity);
}
