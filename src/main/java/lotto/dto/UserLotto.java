package lotto.dto;

import lotto.domain.LottoTicket;

import java.util.List;

public class UserLotto {
    private static List<LottoTicket> userLotto;
    private static int ticketCount;

    public static void createUserLotto(List<LottoTicket> tickets, int count) {
        userLotto = tickets;
        ticketCount = count;
    }

    public static List<LottoTicket> getUserLotto() {
        return userLotto;
    }

    public static int getTicketCount() {
        return ticketCount;
    }

    @Override
    public String toString() {
        return String.format("%s 개를 구매했습니다.", this.ticketCount);
    }
}
