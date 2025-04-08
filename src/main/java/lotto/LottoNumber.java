package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

    private final int number;

    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {

        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (lottoNumberMap.containsKey(number)) {
            return lottoNumberMap.get(number);
        }
        throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    public String toString() {
        return String.valueOf(number);
    }
}
