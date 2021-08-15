package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FAIL(0, 0);

    private final int collectNumber;
    private final int price;

    private static final Map<Integer, LottoRank> LOTTO_RANK_MAP =
        Collections.unmodifiableMap(
            Arrays.stream(values())
                .collect(Collectors.toMap(LottoRank::getCollectNumber, Function.identity())));

    LottoRank(final int collectNumber, final int price) {
        this.collectNumber = collectNumber;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public LottoRank findRank(int collectNumber) {
        return Optional.ofNullable(LOTTO_RANK_MAP.get(collectNumber))
            .orElse(LottoRank.FAIL);
    }
}
