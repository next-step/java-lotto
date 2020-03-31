package lotto;

import java.util.Objects;

public class LottoNo {
    int no;

    public LottoNo(int no) {
        validateLottoNo(no);
        this.no = no;
    }

    public void validateLottoNo(int no) {
        if (no < LottoRule.MIN_NUM.getValue() || no > LottoRule.MAX_NUM.getValue()) {
            throw new IllegalArgumentException("해당 숫자는 로또번호의 범위에 해당되지 않습니다 1~45사이 숫자만 가능");
        }
    }

    public int getNo() {
        return no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof LottoNo)) { return false; }
        LottoNo lottoNo = (LottoNo) o;
        return getNo() == lottoNo.getNo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNo());
    }
}
