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

    LOTTO_PRIZE_FIRST(6, 2000000000),
    LOTTO_PRIZE_SECOND(5, 1500000),
    LOTTO_PRIZE_THIRD(4, 50000),
    LOTTO_PRIZE_FOURTH(3, 5000);


    private Integer sameNumberCnt;
    private Integer prize;

    private static final Map<Integer, Integer> PRIZE_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(LottoPrizeEnum::getSameNumberCnt, LottoPrizeEnum::getPrize)));

    public static Integer getPrizeBySameNumCnt(int sameNumberCnt) {
        return PRIZE_MAP.getOrDefault(sameNumberCnt, 0);
    }

}
