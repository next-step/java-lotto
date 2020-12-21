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
        int size = lottoTicketList.size();
        System.out.printf("%d개를 구매했습니다.\n", size);
        lottoTicketList.forEach(System.out::println);
    }
}
