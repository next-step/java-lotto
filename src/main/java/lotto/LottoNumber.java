package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();
    static {
        for (int i = 1; i < 46; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private int lottoNumber;

    private LottoNumber(int lottoNumber) {
        if (lottoNumber <= 0 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    static LottoNumber of(int number){
        return Optional.of(lottoNos).orElseThrow(IllegalAccessError::new).get(number);
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
