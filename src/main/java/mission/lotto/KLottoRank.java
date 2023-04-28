package mission.lotto;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum KLottoRank {

    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 15000000),
    FIRST(6, 200000000);

    private final int count;
    private final int prize;

    private static final Map<Integer, KLottoRank> RANK_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(KLottoRank::getCount, Function.identity())));

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public static KLottoRank find(int matchCount) {
        if (RANK_MAP.containsKey(matchCount)) {
            return RANK_MAP.get(matchCount);
        }
        throw new IllegalArgumentException("맞는 등수가 없습니다.");
    }

    KLottoRank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }
}
