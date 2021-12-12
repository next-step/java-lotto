package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int number;

    static {
        IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                    .forEach(num -> lottoNumbers.put(num, new LottoNumber(num)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(String number) {
        return from(Integer.parseInt(number));
    }

    public static LottoNumber from(int number) {
        validationLottoNumber(number);
        return lottoNumbers.get(number);
    }

    private static void validationLottoNumber(int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("정확하지 않은 로또 번호입니다.");
        }
    }

    public int getLottoNumber() {
        return number;
    }

    public static List<LottoNumber> getDefaultLottoNumbers() {
        return new ArrayList<>(lottoNumbers.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if(this.number > lottoNumber.getLottoNumber()){
            return 1;
        }
        return -1;
    }
}
