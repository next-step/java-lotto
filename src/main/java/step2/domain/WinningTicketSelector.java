package step2.domain;

import step2.Constant;

import java.util.*;

public class WinningTicketSelector {

    private List<Integer> winningNumbers = new ArrayList<>();
    private Map<Integer, Integer> winningTicketCategoriesByPrize = new LinkedHashMap<>();

    public WinningTicketSelector(String inputWinningNumbers){
        Arrays.stream(inputWinningNumbers.split(Constant.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));
        winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_FOURTH, Constant.ZERO);
        winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_THIRD, Constant.ZERO);
        winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_SECOND, Constant.ZERO);
        winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_FIRST, Constant.ZERO);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Map<Integer, Integer> getWinningTicketCategoriesByPrize() {
        return winningTicketCategoriesByPrize;
    }

    public void findWinningTicket(List<LottoTicket> tickets){

        for(LottoTicket ticket : tickets){
            categorizeWinningTicketByPrize(checkWinningNumberCount(ticket));
        }

    }

    public int checkWinningNumberCount(LottoTicket ticket){
        int count = 0;
        for(int number : ticket.getNumbers()){
            count = checkSameNumber(count, number);
        }
        return count;
    }

    private void categorizeWinningTicketByPrize(int count){
        if(count == Constant.COUNT_THREE){
            winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_FOURTH, winningTicketCategoriesByPrize.get(Constant.LOTTO_PRIZE_FOURTH) + Constant.COUNT_ONE);
        }

        if(count == Constant.COUNT_FOUR){
            winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_THIRD, winningTicketCategoriesByPrize.get(Constant.LOTTO_PRIZE_THIRD) + Constant.COUNT_ONE);
        }

        if(count == Constant.COUNT_FIVE){
            winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_SECOND, winningTicketCategoriesByPrize.get(Constant.LOTTO_PRIZE_SECOND) + Constant.COUNT_ONE);
        }

        if(count == Constant.COUNT_SIX){
            winningTicketCategoriesByPrize.put(Constant.LOTTO_PRIZE_FIRST, winningTicketCategoriesByPrize.get(Constant.LOTTO_PRIZE_FIRST) + Constant.COUNT_ONE);
        }
    }

    private int checkSameNumber(int count, int number){
        return winningNumbers.contains(number) ? count + Constant.COUNT_ONE : count;
    }

}
