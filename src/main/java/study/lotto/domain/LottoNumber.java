package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private static final List<LottoNumber> LOTTO_NUMBER_BASE = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                                                                            .mapToObj(LottoNumber::new)
                                                                            .collect(Collectors.toList());

    private static final List<LottoNumber> LOTTO_NUMBER_SHUFFLE = new ArrayList<>(LOTTO_NUMBER_BASE);

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateLottoNumber(number);
        return LOTTO_NUMBER_BASE.get(number - 1);
    }

    private static void validateLottoNumber(int number) {
        if(number < LOTTO_NUMBER_MIN) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_MIN + "보다 작을 수 없습니다.");
        }

        if(number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_MAX + "보다 클 수 없습니다.");
        }
    }

    static Set<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_SHUFFLE);

        return new TreeSet<>(LOTTO_NUMBER_SHUFFLE.subList(0, 6));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(number, lottoNumber.getNumber());
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof LottoNumber) {
            return number == ((LottoNumber) object).getNumber();
        }

        return false;
    }
}
