package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private int value;

    // 45자리의 로또를 사전에 생성한다.
    static {
        for(int i = LOTTO_NUMBER_MIN ; i <= LOTTO_NUMBER_MAX ; i++){
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }
    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value){
        LottoNumber lottoNumber = lottoNumbers.get(value);
        if(lottoNumber == null){
            throw new IllegalArgumentException("1-45 범위를 벗어나는 로또 숫자가 입력되었습니다.");
        }
        return new LottoNumber(value);
    }

    public int getValue() {
        return value;
    }

    private static List<Integer> lottoRange() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value);
    }
}
