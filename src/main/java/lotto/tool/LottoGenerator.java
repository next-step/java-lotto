package lotto.tool;

import lotto.domain.LottoTicket;

import java.util.List;

public interface LottoGenerator {
    List<LottoTicket> generate();
}
