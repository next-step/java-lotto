package lotto.domain.enums;

import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public enum LottoRank {

    FIRST(6, false, 2000000000), //1등
    SECOND(5, true, 30000000), //2등
    THIRD(5, false, 1500000),    //3등
    FOURTH(4, false, 50000),   //4등
    FIFTH(3, false, 5000), //5등
    MISS(0, false, 0); //꽝

    private final int matchCount;

    private final boolean isMatchBonus;
    private final int reward;

    LottoRank(int matchCount, boolean isMatchBonus, int reward) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.reward = reward;
    }

    public static LottoRank findRank(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.isMatchBonus == isMatchBonus)
                .findFirst()
                .orElse(MISS);
    }

    public static Map<LottoRank, Integer> getResult(WinningNumber winNum, List<LottoTicket> ticket){

        Map<LottoRank, Integer> result = new HashMap<>();

        for (LottoRank lottorank : LottoRank.values()) {
            result.put(lottorank, 0);
        }

        for(LottoTicket lottoTicket : ticket) {
            int matchCnt = (int) lottoTicket.getNumbers().stream()
                    .filter(target -> winNum.getWinningNums().contains(target))
                    .count();
            boolean isBonusMatch = lottoTicket.getNumbers().contains(winNum.getBonusNums());

            LottoRank rankValue = LottoRank.findRank(matchCnt, isBonusMatch);
            result.put(rankValue, result.getOrDefault(rankValue, 0) + 1);
        }

        return result;
    }

    public static double calculateRate(Map<LottoRank, Integer> result, int purchasePrice){
        AtomicInteger sum = new AtomicInteger();
        result.forEach((key, value)->{
            sum.set(sum.get() + key.getReward() * value);
        });
        return (double)(sum.get()) / purchasePrice;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    //enum  문자열 변경
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d개 일치", matchCount));
        if (isMatchBonus) {
            output.append(", 보너스 볼 일치");
        }
        output.append(String.format(" (%,d원)", reward));
        return output.toString();
    }

}