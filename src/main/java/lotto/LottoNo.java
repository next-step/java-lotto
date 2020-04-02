package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNo {
    private static final Map<Integer, LottoNo> lottoNos = new HashMap<>();

    static {
        for (int i = LottoRule.MIN_NUM.getValue(); i <= LottoRule.MAX_NUM.getValue(); i++) {
            lottoNos.put(i, new LottoNo(i));
        }
    }

    private final int no;

    public LottoNo(int no) {
        validateLottoNo(no);
        this.no = no;
    }

    public void validateLottoNo(int no) {
        if (no < LottoRule.MIN_NUM.getValue() || no > LottoRule.MAX_NUM.getValue()) {
            throw new IllegalArgumentException("해당 숫자는 로또번호의 범위에 해당되지 않습니다 1~45사이 숫자만 가능");
        }
    }

    static LottoNo of(int number) {
        return Optional.ofNullable(lottoNos.get(number))
                       .orElseThrow(IllegalArgumentException::new);
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
