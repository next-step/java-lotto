package lotto.domain.strategy;

import lotto.domain.LottoTicket;

import java.util.List;

public interface LottoTicketsGenerator {

    List<LottoTicket> generate();

//    int ticketsPrice();

}
