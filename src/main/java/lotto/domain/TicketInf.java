package lotto.domain;

import java.util.List;
import java.util.Set;

public interface TicketInf {
    Set<Integer> parseToNumbers(String stringNumbers);
    void validateTicket();
    int countMatchNumbers(TicketInf ticketInf);

    //이건 winner 전용
    boolean includeNumber(int number); //사실상 인클루드 보너스임
    int countWinners(List<TicketInf> challengeTicketInfs, Prize prize);
}
