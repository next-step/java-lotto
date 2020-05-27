package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoCheck {
    private static final String SPLIT_REGX = ",";

    final List<Lotto> lottos;
    final List<Integer> winningNumber;
    List<Integer> containWinningNumberCounts;

    public LottoCheck(String winningNumber, List<Lotto> lottos) {
        String[] winningNumberText = winningNumber.split(SPLIT_REGX);
        this.lottos = lottos;
        this.winningNumber = Arrays.stream(winningNumberText)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        this.containWinningNumberCounts = getContainCounts(this.winningNumber);
    }

    private List<Integer> getContainCounts(final List<Integer> winningNumbers) {
        List<Integer> counts = new ArrayList<>();
        for(Lotto lotto : lottos) {
            counts.add(lotto.getContainCount(winningNumbers));
        }
        return counts;
    }

    public int getWinningLottoCount(LottoRank rank) {
        int rankCount = 0;
        for(Integer containCount : containWinningNumberCounts) {
            rankCount = addRankCount(rankCount, containCount, rank);
        }
        return rankCount;
    }

    private int addRankCount(int currentRankCount, Integer containCount, LottoRank rank) {
        int result = currentRankCount;
        if(containCount.equals(rank.getContainCount())) {
            result++;
        }
        return result;
    }

}
