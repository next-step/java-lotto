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
        return getNumberAfterValidate(number);
    }

    public static List<LottoNumber> get(Integer... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer key : numbers) {
            lottoNumbers.add(getNumberAfterValidate(key));
        }
        return lottoNumbers;
    }

    public static List<LottoNumber> getAll() {
        return new ArrayList<>(LOTTO_NUMBER_POOL.values());
    }

    public static LottoNumber get(String number) {
        return get(covertIntAfterValidate(number));
    }

    public static List<LottoNumber> get(String[] numbers) {
        return Arrays.stream(numbers)
                .map(s -> get(covertIntAfterValidate(s)))
                .collect(Collectors.toList());
    }

    private static int covertIntAfterValidate(String number) {
        try {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 숫자형식만 입력이 가능합니다.");
        }
    }

    private static LottoNumber getNumberAfterValidate(Integer key) {
        LottoNumber number = LOTTO_NUMBER_POOL.get(key);
        if(number == null) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호 입니다.");
        }
        return number;
    }
}
