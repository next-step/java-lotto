package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    RANK_1ST(6, 2000000000),
    RANK_2ND(5, 1500000),
    RANK_3RD(4, 50000),
    RANK_4TH(3, 5000),
    RANK_5TH(2, 0),
    RANK_6TH(1, 0),
    RANK_7TH(0, 0);

    private final int collectNumber;
    private final int price;

    LottoRank(final int collectNumber, final int price) {
        this.collectNumber = collectNumber;
        this.price = price;
    }

    private static final Map<Integer, LottoRank> LOTTO_RANK_MAP = Collections.unmodifiableMap(
        Stream.of(values())
            .collect(Collectors.toMap(LottoRank::getCollectNumber, Function.identity())));

    public LottoRank findRank(int collectNumber) {
        return LOTTO_RANK_MAP.get(collectNumber);
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public int getPrice() {
        return price;
    }
}
