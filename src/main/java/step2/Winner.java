package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.LottoMatch.*;

public class Winner {

    private static Map<Integer, Integer> winnerMap = new HashMap<>();

    public Map<Integer, Integer> findWinner(List<Ticket> tickets, String winnerString) {
        winnerMapInit();

        List<Integer> winnerTicket = winnerTicket(winnerString);

        for (Ticket ticket : tickets) {
            oneTicketCheck(ticket, winnerTicket);
        }

        return winnerMap;
    }

    private static void winnerMapInit() {
        winnerMap.put(FOURTH.getMatchCount(), 0);
        winnerMap.put(THIRD.getMatchCount(), 0);
        winnerMap.put(SECOND.getMatchCount(), 0);
        winnerMap.put(FIRST.getMatchCount(), 0);
    }

    private void oneTicketCheck(Ticket ticket, List<Integer> winnerTicket) {
        int matchCount = 0;

        List<Integer> oneTicket = ticket.getNumbers();
        for (Integer num : winnerTicket) {
            matchCount += isTicketContainsNumber(oneTicket, num);
        }
        plusWinnerMapCount(matchCount);
    }

    private void plusWinnerMapCount(int matchCount) {
        if(matchCount >= 3){
            winnerMap.put(matchCount, winnerMap.get(matchCount)+1);
        }
    }

    private int isTicketContainsNumber(List<Integer> oneTicket, Integer num) {
        if(oneTicket.contains(num)){
            return 1;
        }
        return 0;
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
