package lotto.utils;

import org.omg.CORBA.UNKNOWN;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RankEnum {
    RANK_THREE(3L, "3개 일치 (5000원)- "),
    RANK_FOUR(4L, "4개 일치 (50000원)- "),
    RANK_FIVE(5L, "5개 일치 (1500000원)- "),
    RANK_SIX(6L, "6개 일치 (2000000000원)- ");

    private final Long rank;
    private final String msg;

    RankEnum(Long rank, String msg) {
        this.rank = rank;
        this.msg = msg;
    }

    private static final Map<Long, RankEnum> rankEnums =
            Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(RankEnum::getRank, Function.identity())));

    public Long getRank() {
        return rank;
    }

    public String getMsg() {
        return msg;
    }

    public static RankEnum findBy(Long rank) {
        return Optional.ofNullable(rankEnums.get(rank)).orElse(null);
    }

}
