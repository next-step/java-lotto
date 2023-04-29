package lotto.domain;

import java.util.List;
import java.util.Set;

public interface Ticket {
    Set<Integer> parseToNumbers(String stringNumbers);
    void validateTicket();
    int countMatchNumbers(Ticket ticket);

    //이건 winner 전용
    boolean includeNumber(int number); //사실상 인클루드 보너스임
    int countWinners(List<Ticket> challengeTickets, Prize prize);
}
