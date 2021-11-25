package lotto.utils;

import org.omg.CORBA.UNKNOWN;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RankEnum {
    RANK_THREE(3L, 5000L,"3개 일치 (5000원)- "),
    RANK_FOUR(4L, 50000L, "4개 일치 (50000원)- "),
    RANK_FIVE(5L, 1500000L, "5개 일치 (1500000원)- "),
    RANK_SIX(6L, 2000000000L,"6개 일치 (2000000000원)- ");

    private final Long rank;
    private final Long reward;
    private final String msg;

    RankEnum(Long rank, Long reward, String msg) {
        this.rank = rank;
        this.reward = reward;
        this.msg = msg;
    }

    private static final Map<Long, RankEnum> rankEnums =
            Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(RankEnum::getRank, Function.identity())));

    public Long getRank() {
        return rank;
    }

    public Long getReward() {
        return reward;
    }

    public String getMsg() {
        return msg;
    }

    public static RankEnum findBy(Long rank) {
        return Optional.ofNullable(rankEnums.get(rank)).orElse(null);
    }

}
