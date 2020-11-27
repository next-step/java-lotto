package lotto.model;

import java.util.*;

public class WinningCheckor {
    Set<Integer> preNumbers;
    EnumMap<Rank, Integer> winningStatics;

    public WinningCheckor(Set<Integer> preNumbers) {
        this.preNumbers = preNumbers;
        winningStatics = new EnumMap<>(Rank.class);
        winningStatics.put(Rank.FIRST,0);
        winningStatics.put(Rank.SECOND,0);
        winningStatics.put(Rank.THIRD,0);
        winningStatics.put(Rank.FOURTH,0);
        winningStatics.put(Rank.NO_MATCH,0);
    }

    //당첨금 통계내기
    public EnumMap<Rank, Integer> makeStatics(LottoTickets lottoTickets) {

        for (int i = 0; i < lottoTickets.getTicketCount(); i++) {
            int winningCount = checkWinning(lottoTickets.oneOf(i).getTicketNumbers());
            Rank winningRank = Rank.rank(winningCount);
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
