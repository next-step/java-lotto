package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.LottoMatch.*;

public class Winner {

    public static final int WINNER_COUNT_MINIMUM = 3;

    private static Map<String, Integer> winnerMap = new HashMap<>();

    public Map<String, Integer> findWinner(List<Ticket> tickets, String winnerString, int bonus) {
        winnerMapInit();

        Ticket winnerTicket = makeWinnerTicket(winnerString);

        for (Ticket ticket : tickets) {
            oneTicketCheck(ticket, winnerTicket, bonus);
        }

        return winnerMap;
    }

    private static void winnerMapInit() {
        winnerMap.put(FIFTH.name(), 0);
        winnerMap.put(FOURTH.name(), 0);
        winnerMap.put(THIRD.name(), 0);
        winnerMap.put(SECOND.name(), 0);
        winnerMap.put(FIRST.name(), 0);
    }

    private Ticket makeWinnerTicket(String winnerString) {
        List<Integer> winnerNumbers = new ArrayList<>();

        String[] split = winnerString.split(",");
        for (String s : split) {
            winnerNumbers.add(Integer.parseInt(s.trim()));
        }

        return new Ticket(winnerNumbers);
    }

    private void oneTicketCheck(Ticket ticket, Ticket winnerTicket, int bonus) {
        int matchCount = 0;
        boolean isBonusMatch = false;

        List<Integer> oneTicket = ticket.getNumbers();
        for (Integer num : winnerTicket.getNumbers()) {
            matchCount += isTicketContainsNumber(oneTicket, num);
        }
        //bonusCheck
        if(matchCount == SECOND.getMatchCount()){
            isBonusMatch = isTicketContainsNumber_bonus(oneTicket, bonus);
        }

        plusWinnerMapCount(matchCount, isBonusMatch);
    }

    private int isTicketContainsNumber(List<Integer> oneTicket, Integer num) {
        if(oneTicket.contains(num)){
            return 1;
        }
        return 0;
    }

    private boolean isTicketContainsNumber_bonus(List<Integer> oneTicket, Integer num) {
        if(oneTicket.contains(num)){
            return true;
        }
        return false;
    }

    private void plusWinnerMapCount(int matchCount, boolean isBonusMatch) {
        if(matchCount >= WINNER_COUNT_MINIMUM){
            LottoMatch lottoMatch = LottoMatch.valueOf(matchCount, isBonusMatch);
            winnerMap.put(lottoMatch.name(), winnerMap.get(lottoMatch.name())+1);
        }
    }
}
