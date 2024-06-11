package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final int num;
    private static HashMap<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    public static LottoNumber of(int num) {
        if (lottoNumbers.containsKey(num)) return lottoNumbers.get(num);
        LottoNumber lottoNumber = new LottoNumber(num);
        lottoNumbers.put(num, lottoNumber);
        return lottoNumber;
    }

    public int getNum() {
        return num;
    }

    private LottoNumber(int num) {
        validate(num);
        this.num = num;
    }

    private static void validate(int num) {
        if (num < 1 || num > 45){
            throw new IllegalArgumentException("로또 숫자가 범위를 초과하였습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "num=" + num +
                '}';
    }
}
