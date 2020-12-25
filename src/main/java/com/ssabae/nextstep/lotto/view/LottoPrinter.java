package com.ssabae.nextstep.lotto.view;

import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTickets;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoPrinter {

    public static void print(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        int manualTicketCount = lottoTickets.getManualTicketCount();
        int autoTicketCount = lottoTicketList.size() - manualTicketCount;
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualTicketCount, autoTicketCount);
        lottoTicketList.forEach(System.out::println);
    }
}
