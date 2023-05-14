package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.LottoMatch.*;

public class Winner {

    private int matchCount;
    private static Map<Integer, Integer> winnerMap = new HashMap<>();
    static{
        winnerMap.put(FOURTH.getMatchCount(), 0);
        winnerMap.put(THIRD.getMatchCount(), 0);
        winnerMap.put(SECOND.getMatchCount(), 0);
        winnerMap.put(FIRST.getMatchCount(), 0);
    }

    public Map<Integer, Integer> findWinner(List<Ticket> tickets, String winnerString) {
        List<Integer> winnerTicket = winnerTicket(winnerString);

        for (Ticket ticket : tickets) {
            oneTicketCheck(ticket, winnerTicket);
        }

        return winnerMap;
    }

    private void oneTicketCheck(Ticket ticket, List<Integer> winnerTicket) {
        matchCount = 0;

        List<Integer> oneTicket = ticket.getTicket();
        for (Integer num : winnerTicket) {
            isTicketContainsNumber(oneTicket, num);
        }
        plusWinnerMapCount();
    }

    private void plusWinnerMapCount() {
        if(matchCount >= 3){
            winnerMap.put(matchCount, winnerMap.get(matchCount)+1);
        }
    }

    private void isTicketContainsNumber(List<Integer> oneTicket, Integer num) {
        if(oneTicket.contains(num)){
           matchCount++;
        }
    }

    private List<Integer> winnerTicket(String winnerString) {
        List<Integer> winnerTicket = new ArrayList<>();

        String[] split = winnerString.split(",");
        for (String s : split) {
            winnerTicket.add(Integer.parseInt(s.trim()));
        }

        return winnerTicket;
    }
}
