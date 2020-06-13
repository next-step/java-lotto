package lotto.domain.data;

import lotto.domain.data.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPool {
    private final static Map<Integer, LottoNumber> LOTTO_NUMBER_POOL =
            Collections.unmodifiableMap(
                    IntStream.rangeClosed(LottoNumber.LOTTO_START_NUMBER, LottoNumber.LOTTO_LAST_NUMBER).boxed()
                        .collect(Collectors.toMap(Integer::intValue, LottoNumber::of)));

    private LottoNumberPool() {}

    public static LottoNumber get(int number) {
        return Optional.ofNullable(LOTTO_NUMBER_POOL.get(number))
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 로또 번호 입니다."));
    }

    public static List<LottoNumber> getAll() {
        return new ArrayList<>(LOTTO_NUMBER_POOL.values());
    }

    public static List<LottoNumber> get(List<Integer> number) {
        return number.stream()
                .map(integer -> Optional.ofNullable(LOTTO_NUMBER_POOL.get(integer))
                        .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 로또 번호 입니다.")))
                .collect(Collectors.toList());
    }
}
