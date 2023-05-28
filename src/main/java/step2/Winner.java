package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.LottoMatch.*;

public class Winner {

    public static final int WINNER_COUNT_MINIMUM = 3;

    Ticket winnerTicket;
    int bonus;

    public Map<String, Integer> findWinner(List<Ticket> tickets, String winnerString, int bonusNum) {
        WinnerMap.winnerMapInit();

        this.winnerTicket = makeWinnerTicket(winnerString);
        this.bonus = bonusNum;

        for (Ticket ticket : tickets) {
            oneTicketCheck(ticket);
        }

        return WinnerMap.getWinnerMap();
    }

    private Ticket makeWinnerTicket(String winnerString) {
        List<Integer> winnerNumbers = new ArrayList<>();

        String[] split = winnerString.split(",");
        for (String s : split) {
            winnerNumbers.add(Integer.parseInt(s.trim()));
        }

        return new Ticket(winnerNumbers);
    }

    private void oneTicketCheck(Ticket oneTicket) {
        int matchCount = 0;
        boolean isBonusMatch = false;

        for (Integer num : winnerTicket.getNumbers()) {
            matchCount += isTicketContainsNumber(oneTicket, num);
        }
        //bonusCheck
        if(matchCount == SECOND.getMatchCount()){
            isBonusMatch = isTicketContainsNumber_bonus(oneTicket, bonus);
        }

        if(matchCount >= WINNER_COUNT_MINIMUM){
            LottoMatch lottoMatch = LottoMatch.valueOf(matchCount, isBonusMatch);
            WinnerMap.plusWinnerMapCount(lottoMatch, matchCount);
        }
    }

    private int isTicketContainsNumber(Ticket oneTicket, Integer num) {
        if(oneTicket.isContainNumber(num)){
            return 1;
        }
        return 0;
    }

    private boolean isTicketContainsNumber_bonus(Ticket oneTicket, Integer num) {
        if(oneTicket.isContainNumber(num)){
            return true;
        }
        return false;
    }

}
