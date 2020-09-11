package step2.domain;

import step2.Constant;

import java.util.*;

public class WinningTicketSelector {

    private final List<Integer> winningNumbers = new ArrayList<>();
    private final int bonusNumber;

    public WinningTicketSelector(String inputWinningNumbers, int bonusNumber){
        Arrays.stream(inputWinningNumbers.split(Constant.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));
        if(winningNumbers.size() != Constant.COUNT_SIX){
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<LottoTicket> findWinningTicket(List<LottoTicket> tickets){

        for(LottoTicket ticket : tickets){
            ticket.checkWinningTicket(winningNumbers, bonusNumber);
        }

        return tickets;
    }

    public Map<Integer, List<LottoTicket>> categorizeWinningTicket(List<LottoTicket> tickets){
        Map<Integer, List<LottoTicket>> winningTickets = new LinkedHashMap<>();
        winningTickets.put(Constant.LOTTO_PRIZE_FIFTH, new ArrayList<>());
        winningTickets.put(Constant.LOTTO_PRIZE_FOURTH, new ArrayList<>());
        winningTickets.put(Constant.LOTTO_PRIZE_THIRD, new ArrayList<>());
        winningTickets.put(Constant.LOTTO_PRIZE_SECOND, new ArrayList<>());
        winningTickets.put(Constant.LOTTO_PRIZE_FIRST, new ArrayList<>());

        for(LottoTicket ticket : tickets){
            selectWinningTicketByPrize(winningTickets, ticket);
        }

        return  winningTickets;
    }

    private void selectWinningTicketByPrize(Map<Integer, List<LottoTicket>> winningTickets, LottoTicket ticket){
        if(ticket.getPrizeResult() == 0){
            return;
        }

        winningTickets.get(ticket.getPrizeResult()).add(ticket);
    }

}
