package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer,LottoNumber> NUMBERS = new HashMap<>();
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        vaildate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(num -> NUMBERS.put(num,new LottoNumber(num)));
    }

    private static void vaildate(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || MAX_NUMBER < lottoNumber) {
            throw new IllegalArgumentException("숫자 범위 벗어남");
        }
    }

    public static LottoNumber getLottoNumber(Integer lottoNumber) {
        vaildate(lottoNumber);
        return NUMBERS.get(lottoNumber);
    }

    public static List<LottoNumber> getAllLottoNumbers(){
        return NUMBERS.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof LottoNumber) {
            return this.lottoNumber == ((LottoNumber) obj).lottoNumber;
        }

        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.lottoNumber, lottoNumber.getLottoNumber());
    }
}
