package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();
    private int lottoNumber;

    static {
        for (int i = 1; i < 46; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    static LottoNumber of(int number){
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
