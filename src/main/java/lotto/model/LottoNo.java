package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNo {
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    private static final Map<Integer, LottoNo> lottoNos = new HashMap<>();
    static {
        IntStream.rangeClosed(1, 45)
                .forEach(i -> lottoNos.put(i, new LottoNo(i)));
    }

    private final int lottoNo;

    public LottoNo(int lottoNo) {
        validationNumberRange(lottoNo);

        this.lottoNo = lottoNo;
    }

    public static LottoNo from(int lottoNo) {
        validationNumberRange(lottoNo);

        return lottoNos.get(lottoNo);
    }

    public static LottoNo from(String value) {
        return from(Integer.parseInt(value));
    }

    private static void validationNumberRange(Integer lottoNo) {
        if(lottoNo < LOTTO_NUMBER_START_RANGE || lottoNo > LOTTO_NUMBER_END_RANGE) {
            throw new IllegalArgumentException("숫자는 1부터 45사이의 값을 입력하세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }

    @Override
    public String toString() {
        return "" + lottoNo;
    }
}
