package step2.domain;

import step2.Constant;

import java.util.*;

public class WinningTicketSelector {

    private final List<Integer> winningNumbers = new ArrayList<>();

    public WinningTicketSelector(String inputWinningNumbers){
        Arrays.stream(inputWinningNumbers.split(Constant.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<LottoTicket> findWinningTicket(List<LottoTicket> tickets){

        for(LottoTicket ticket : tickets){
            ticket.checkWinningTicket(winningNumbers);
        }

        return tickets;
    }

    public Map<Integer, List<LottoTicket>> categorizeWinningTicket(List<LottoTicket> tickets){
        Map<Integer, List<LottoTicket>> winningTickets = new LinkedHashMap<>();
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

        if(ticket.getPrizeResult() == Constant.LOTTO_PRIZE_FOURTH){
            winningTickets.get(Constant.LOTTO_PRIZE_FOURTH).add(ticket);
        }

        if(ticket.getPrizeResult() == Constant.LOTTO_PRIZE_THIRD){
            winningTickets.get(Constant.LOTTO_PRIZE_THIRD).add(ticket);
        }

        if(ticket.getPrizeResult() == Constant.LOTTO_PRIZE_SECOND){
            winningTickets.get(Constant.LOTTO_PRIZE_SECOND).add(ticket);
        }

        if(ticket.getPrizeResult() == Constant.LOTTO_PRIZE_FIRST){
            winningTickets.get(Constant.LOTTO_PRIZE_FIRST).add(ticket);
        }

    }

}
