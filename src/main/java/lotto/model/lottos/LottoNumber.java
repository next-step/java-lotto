package lotto.model.lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.Messages.WARNING_LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Integer> lottoPool = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoPool.add(i);
        }
    }

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static List<Integer> getLottoPool(){
        return lottoPool;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (!lottoPool.contains(lottoNumber)) {
            throw new IllegalArgumentException(WARNING_LOTTO_NUMBER_RANGE);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
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
