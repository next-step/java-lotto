package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPlace {

    FOURTH_PLACE(5000, 3),
    THIRD_PLACE(50000, 4),
    SECOND_PLACE(1500000, 5),
    FIRST_PLACE(2000000000, 6);

    private final int prize;
    private final int count;

    LottoPlace(int prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    private static final Map<Integer, LottoPlace> map = Arrays.stream(values())
        .collect(Collectors.toUnmodifiableMap(LottoPlace::getCount, Function.identity()));

    public static LottoPlace getLottoPlace(int count) {

        return Optional.ofNullable(map.get(count))
            .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 등 수 입니다"));
    }
}
