package lotto.model;

import java.util.*;

public class WinningCheckor {
    Set<Integer> preNumbers;
    EnumMap<Rank, Integer> winningStatics;
    int bonusNumber;

    public WinningCheckor(Set<Integer> preNumbers, int bonusNumber) {
        this.preNumbers = preNumbers;
        winningStatics = new EnumMap<>(Rank.getInitWinningStatics());
        this.bonusNumber = bonusNumber;
    }

    //당첨금 통계내기
    public EnumMap<Rank, Integer> makeStatics(LottoTickets lottoTickets) {

        for (int i = 0; i < lottoTickets.getTicketCount(); i++) {
            int winningCount = checkWinning(lottoTickets.oneOf(i).getTicketNumbers());
            boolean matchBonus = lottoTickets.oneOf(i).getTicketNumbers().contains(bonusNumber);
            Rank winningRank = Rank.rank(winningCount,matchBonus);
            winningStatics.put(winningRank, winningStatics.get(winningRank) + winningRank.getMoney());
        }
        return winningStatics;
    }

    //당첨개수 확인
    public int checkWinning(List<Integer> lottoTicket) {
        int winningCount = 0;
        for (Integer number : lottoTicket) {
            winningCount += preNumbers.contains(number) ? 1 : 0;
        }
        return winningCount;
    }

}
