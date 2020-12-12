package step2.domain;

import java.util.Objects;

public class LottoNo {

    private final int number;

    public LottoNo(Integer lottoNumber) {
        this.number = lottoNumber;
    }

    public static LottoNo create(Integer lottoNumber) {
        if (isNotLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력하였습니다.");
        }
        return new LottoNo(lottoNumber);
    }

    private static boolean isNotLottoNumber(int number) {
        return number < LottoConstant.START_NO || number > LottoConstant.END_NO;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
