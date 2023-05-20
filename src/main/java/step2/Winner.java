package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.LottoMatch.*;

public class Winner {

    private static Map<Double, Integer> winnerMap = new HashMap<>();

    public Map<Double, Integer> findWinner(List<Ticket> tickets, String winnerString, int bonus) {
        winnerMapInit();

        List<Integer> winnerTicket = winnerTicket(winnerString);

        for (Ticket ticket : tickets) {
            oneTicketCheck(ticket, winnerTicket, bonus);
        }

        return winnerMap;
    }

    private static void winnerMapInit() {
        winnerMap.put(FOURTH.getMatchCount(), 0);
        winnerMap.put(THIRD.getMatchCount(), 0);
        winnerMap.put(SECOND.getMatchCount(), 0);
        winnerMap.put(SECOND_BONUS.getMatchCount(), 0);
        winnerMap.put(FIRST.getMatchCount(), 0);
    }

    private List<Integer> winnerTicket(String winnerString) {
        List<Integer> winnerTicket = new ArrayList<>();

        String[] split = winnerString.split(",");
        for (String s : split) {
            winnerTicket.add(Integer.parseInt(s.trim()));
        }

        return winnerTicket;
    }

    private void oneTicketCheck(Ticket ticket, List<Integer> winnerTicket, int bonus) {
        double matchCount = 0.0;

        List<Integer> oneTicket = ticket.getNumbers();
        for (Integer num : winnerTicket) {
            matchCount += isTicketContainsNumber(oneTicket, num);
        }
        //bonusCheck
        if(matchCount == SECOND.getMatchCount()){
            matchCount += isTicketContainsNumber_bonus(oneTicket, bonus);
        }

        plusWinnerMapCount(matchCount);
    }

    private double isTicketContainsNumber(List<Integer> oneTicket, Integer num) {
        if(oneTicket.contains(num)){
            return 1.0;
        }
        return 0.0;
    }

    private double isTicketContainsNumber_bonus(List<Integer> oneTicket, Integer num) {
        if(oneTicket.contains(num)){
            return 0.5;
        }
        return 0.0;
    }

    private void plusWinnerMapCount(double matchCount) {
        if(matchCount >= 3){
            winnerMap.put(matchCount, winnerMap.get(matchCount)+1);
        }
    }
}
