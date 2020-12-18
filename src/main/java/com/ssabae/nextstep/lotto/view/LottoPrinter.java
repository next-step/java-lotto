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

    //-- LottoMachine 에서 Log 성으로 보여줄 부분 --
    //14개를 구매했습니다.
    //[8, 21, 23, 41, 42, 43]
    //[3, 5, 11, 16, 32, 38]
    //[7, 11, 16, 35, 36, 44]
    //[1, 8, 11, 31, 41, 42]
    //[13, 14, 16, 38, 42, 45]
    //[7, 11, 30, 40, 42, 43]
    //[2, 13, 22, 32, 38, 45]
    //[23, 25, 33, 36, 39, 41]
    //[1, 3, 5, 14, 22, 45]
    //[5, 9, 38, 41, 43, 44]
    //[2, 8, 9, 18, 19, 21]
    //[13, 14, 18, 21, 23, 35]
    //[17, 21, 29, 37, 42, 45]
    //[3, 8, 27, 30, 35, 44]
}
