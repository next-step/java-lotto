package lotto.domain.lottogenerator;

import lotto.domain.LottoTicket;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {

    List<LottoTicket> create();

}
