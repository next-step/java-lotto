package Lotto.dto;

import Lotto.model.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResultDto {
    private final int matchCount;
    private final int prize;
    private final int count; // 당첨자 수

    public RankResultDto(int matchCount, int prize, int count) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.count = count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public static List<RankResultDto> convertToDtos(Map<LottoRank, Integer> winningCountMap){
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .map(rank -> new RankResultDto(
                        rank.getCountOfMatch(),
                        rank.getWinningMoney(),
                        winningCountMap.getOrDefault(rank, 0)
                ))
                .collect(Collectors.toList());
    }
}

