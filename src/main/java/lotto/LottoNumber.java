package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;
    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_NUMBER_MINIMUM_RANGE = 1;
    private static final int LOTTO_NUMBER_MAXIMUM_RANGE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    static {
        for (int number = LOTTO_NUMBER_MINIMUM_RANGE; number <= LOTTO_NUMBER_MAXIMUM_RANGE; number++) {
            lottoNumberCache.put(number, new LottoNumber(number));
            lottoNumbers.add(LottoNumber.of(number));
        }
    }

    private LottoNumber(final int number) {
        if (validateNumber(number)) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.");
        }
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        if (lottoNumberCache.get(number) == null) {
            lottoNumberCache.put(number, new LottoNumber(number));
        }
        return lottoNumberCache.get(number);
    }

    public static List<LottoNumber> of(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private int getNumber() {
        return number;
    }

    private boolean validateNumber(int number) {
        return number < 1 || number > 45;
    }

    public static List<LottoNumber> generate() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.getNumber(), o.getNumber());
    }
}
