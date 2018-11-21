package domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNo {
    private int num;
    private static Map<Integer, LottoNo> lottoNumbers = new HashMap<>();

    static {
        IntStream.range(1, 46).forEach(i ->
            lottoNumbers.put(i, new LottoNo(i)));
    }

    private LottoNo(int num) {
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    public static LottoNo from(int num) {
        return lottoNumbers.get(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return num == lottoNo.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "LottoNo{" +
                "num=" + num +
                '}';
    }
}
