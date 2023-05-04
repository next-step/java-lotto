package step2;

import java.util.*;

public class WinningTicketSelector {

    private final List<Integer> winningNumbers = new ArrayList<>();

    public WinningTicketSelector(String inputWinningNumbers) {
        Arrays.stream(inputWinningNumbers.replaceAll(" ", "").split(LottoMessage.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));

    }

    public void findWinningTicket(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            ticket.checkWinningTicket(winningNumbers);
        }
    }

    public void countWinningTicket(Map<Integer, List<LottoTicket>> winningTicketsMap, List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            if(ticket.getSameNumberCount()>=3)
                winningTicketsMap.get(ticket.getSameNumberCount()).add(ticket);
        }
    }
}
