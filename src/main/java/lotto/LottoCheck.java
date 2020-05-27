package lotto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoRank.*;

public class LottoCheck {
    private static final String SPLIT_REGX = ",";

    private final List<Lotto> lottos;
    private final List<Integer> winningNumber;
    private List<Integer> containWinningNumberCounts;

    public LottoCheck(String winningNumber, List<Lotto> lottos) {
        String[] winningNumberText = winningNumber.split(SPLIT_REGX);
        this.lottos = lottos;
        this.winningNumber = Arrays.stream(winningNumberText)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        this.containWinningNumberCounts = getContainCountsSame(this.winningNumber);
    }

    private List<Integer> getContainCountsSame(final List<Integer> winningNumbers) {
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
        if(containCount.equals(rank.getContainCountsSameWinningNumber())) {
            result++;
        }
        return result;
    }

    public BigDecimal getWinningAmount() {
        return getWinningAmount(RANK1)
                .add(getWinningAmount(RANK2))
                .add(getWinningAmount(RANK3))
                .add(getWinningAmount(RANK4));
    }

    private BigDecimal getWinningAmount(LottoRank lottoRank) {
        return BigDecimal.valueOf(getWinningLottoCount(lottoRank)).multiply(lottoRank.getWinningAmount());
    }
}
