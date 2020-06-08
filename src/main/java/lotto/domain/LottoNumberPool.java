package lotto.domain;

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
        validateIfContainLottoNumberPool(number);
        return LOTTO_NUMBER_POOL.get(number);
    }

    public static List<LottoNumber> getAll() {
        return new ArrayList<>(LOTTO_NUMBER_POOL.values());
    }

    public static LottoNumber get(String number) {
        validateIfParseNumberFormat(number);
        int intAfterPare = Integer.parseInt(number);
        validateIfContainLottoNumberPool(intAfterPare);
        return LOTTO_NUMBER_POOL.get(intAfterPare);
    }

    private static void validateIfParseNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 숫자형식만 입력이 가능합니다.");
        }
    }

    private static void validateIfContainLottoNumberPool(int number) {
        if(!LOTTO_NUMBER_POOL.containsKey(number)) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호 입니다.");
        }
    }

}
