package step3.domain;

import step3.utils.Constant;
import java.util.*;

public class WinningTicketSelector {

    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    private List<WinningType> winningTypes;

    public WinningTicketSelector(String inputWinningNumbers, int bonusNumber){
        Arrays.stream(inputWinningNumbers.split(Constant.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));
        if(winningNumbers.size() != Constant.COUNT_SIX){
            throw new IllegalArgumentException();
        }
        if(!((Constant.LOTTO_START_NUMBER <= bonusNumber) && (bonusNumber <= Constant.LOTTO_LAST_NUMBER))){
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
    }

    public void findWinningTicket(List<LottoTicket> tickets){
        winningTypes = new ArrayList<>();

        for(LottoTicket ticket : tickets){
            checkNonWinningTicket(winningTypes, ticket);
        }
    }

    public List<WinningType> getWinningTypes() {
        return winningTypes;
    }

    private void checkNonWinningTicket(List<WinningType> winningTypes, LottoTicket ticket){
        WinningType winningType = WinningType.getTicketLevel(calculateSameNumberCount(ticket, winningNumbers), hasBonusNumber(ticket));
        if(winningType == null){
            return;
        }
        winningTypes.add(winningType);
    }

    private int calculateSameNumberCount(LottoTicket ticket, List<Integer> winningNumbers){
        return (int) ticket.getLottoNumbers().stream().filter(winningNumbers::contains).count();
    }

    private boolean hasBonusNumber(LottoTicket ticket){
        return  ticket.getLottoNumbers().contains(bonusNumber);
    }

}
