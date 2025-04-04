package Lotto.dto;

import Lotto.model.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResultDto {
    private static final String SECOND_RANK_MESSAGE = ", 보너스 볼 일치";
    private static final String GENERAL_RANK_MESSAGE = " ";
    private final int matchCount;
    private final int prize;
    private final int count; // 당첨자 수
    private final String message;


    public RankResultDto(int matchCount, int prize, int count, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.count = count;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage(){
        return message;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public static List<RankResultDto> convertToDtos(Map<LottoRank, Integer> winningCountMap) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .map(rank -> new RankResultDto(
                        rank.getCountOfMatch(),
                        rank.getWinningMoney(),
                        winningCountMap.getOrDefault(rank, 0),
                        rank == LottoRank.SECOND ? SECOND_RANK_MESSAGE : GENERAL_RANK_MESSAGE
                ))
                .collect(Collectors.toList());
    }
}

