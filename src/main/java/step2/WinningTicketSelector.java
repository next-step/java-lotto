package step2;

import java.util.*;

public class WinningTicketSelector {

    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public WinningTicketSelector(String inputWinningNumbers, int bonusNumber) {
        Arrays.stream(inputWinningNumbers
                        .replaceAll(" ", "")
                        .split(LottoMessage.WINNING_NUMBER_SEPERATOR))
                .forEach(e -> winningNumbers.add(Integer.parseInt(e)));
        this.bonusNumber = bonusNumber;
    }

    public List<LottoTicket> findWinningTicket(List<LottoTicket> tickets) {
        tickets.forEach(ticket -> ticket.checkWinningTicket(winningNumbers, bonusNumber));
        return tickets;
    }

    public Map<Integer, List<LottoTicket>> countWinningTicket(Map<Integer, List<LottoTicket>> winningTicketsMap, List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            if (ticket.getSameNumberCount() >= 3)
                winningTicketsMap.get(ticket.getPrizeResult()).add(ticket);
        }

        return winningTicketsMap;
    }
}
