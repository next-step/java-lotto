package lotto.domain;

public class LottoNo {
    private static final LottoNo[] INSTANCES = new LottoNo[LottoNumbers.LOTTO_END_NUMBER + 1];
    private final int value;

    static {
        for (int i = LottoNumbers.LOTTO_START_NUMBER; i <= LottoNumbers.LOTTO_END_NUMBER; i++) {
            INSTANCES[i] = new LottoNo(i);
        }
    }

    private LottoNo(int value) {
        this.value = value;
    }

    public static LottoNo of(int number) {
        return INSTANCES[number];
    }

    public boolean isValid() {
        return value >= LottoNumbers.LOTTO_START_NUMBER && value <= LottoNumbers.LOTTO_END_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return value == lottoNo.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
