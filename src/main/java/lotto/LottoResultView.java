package lotto;

import java.util.List;

public class LottoResultView {
    public static void print(List<LottoTicket> ticketList) {
        System.out.println(ticketList.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : ticketList) {
            System.out.println(ticket);
        }
    }
}
