package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinningCheck {

    private List<Rank> rankList;

    public WinningCheck(List<LottoTicket> lottoTickets, List<Integer> winningNumbers, int bonusBall) {
        rankList = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            rankList.add(
                    Rank.of(
                            getMatchCount(lottoTicket.getLottoTicket(), winningNumbers),
                            hasBonusBall(lottoTicket.getLottoTicket(), bonusBall)));
        }
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    private int getMatchCount(List<Integer> lottoTicket, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int winningNumber : winningNumbers) {
            if (lottoTicket.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean hasBonusBall(List<Integer> lottoTicket, int bonusBall) {
        if (lottoTicket.contains(bonusBall)) {
            return true;
        }
        return false;
    }

    public void nullToZero(Map<Rank, Long> rankCountMap){
        for(Rank rank : Rank.values()){
            rankCountMap.putIfAbsent(rank, 0L);
        }
    }

    public double getProceeds(Map<Rank, Long> rankCountMap) {
        double proceeds = 0;

        for(Rank rank : Rank.values()){
            proceeds += (Integer.parseInt(rank.getPrice()) * (double)rankCountMap.get(rank));
        }

        return proceeds;
    }
}
