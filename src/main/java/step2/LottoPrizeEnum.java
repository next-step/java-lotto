package step2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum LottoPrizeEnum {

    LOTTO_PRIZE_FIRST(1, 6, 2000000000),
    LOTTO_PRIZE_SECOND(2, 5, 30000000),
    LOTTO_PRIZE_THIRD(3, 5, 1500000),
    LOTTO_PRIZE_FOURTH(4, 4, 50000),
    LOTTO_PRIZE_FIFTH(5, 3, 5000);

    private Integer rank;
    private Integer sameNumberCnt;
    private Integer prize;

    private static final Map<Integer, Integer> PRIZE_MAP = Collections.unmodifiableMap(
            Stream.of(values())
                    .filter(x -> x.getRank() != 2)
                    .collect(Collectors.toMap(LottoPrizeEnum::getSameNumberCnt, LottoPrizeEnum::getPrize)));

    private static final Map<Integer, Integer> RANK_MAP = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoPrizeEnum::getPrize, LottoPrizeEnum::getRank)));


    private static final Map<Integer, Integer> CNT_MAP = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoPrizeEnum::getRank, LottoPrizeEnum::getSameNumberCnt)));

    public static Integer getPrizeBySameNumCnt(int sameNumberCnt, boolean hasBonusNum) {
        if (hasBonusNum && sameNumberCnt == 5) return LOTTO_PRIZE_SECOND.prize;
        return PRIZE_MAP.getOrDefault(sameNumberCnt, 0);
    }

    public static Integer getRankByPrize(int prize) {
        return RANK_MAP.getOrDefault(prize, 0);
    }

    public static Integer getCntByRank(int rank) {
        return CNT_MAP.getOrDefault(rank, 0);
    }
}
