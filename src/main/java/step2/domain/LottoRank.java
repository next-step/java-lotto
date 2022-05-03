package step2.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    ETC(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private static final Map<Long, LottoRank> LOTTO_RANK_MAP = initLottoRankMap();

    private final long hitCount;
    private final int prizeMoney;

    LottoRank(long hitCount, int prizeMoney) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
    }

    private static Map<Long, LottoRank> initLottoRankMap() {

        Map<Long, LottoRank> result = Stream.of(LottoRank.values())
                .collect(Collectors.toMap(lottoRank -> lottoRank.hitCount, lottoRank -> lottoRank));
        result.remove(0L);
        return result;
    }

    public static LottoRank toRank(Long hitCount) {
        if (LOTTO_RANK_MAP.containsKey(hitCount)) {
            return LOTTO_RANK_MAP.get(hitCount);
        }
        return LottoRank.ETC;
    }

    public long getHitCount() {
        return hitCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
