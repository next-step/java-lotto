package step2.domain.Lotto;

import step2.domain.Constant;

public class LottoNum {
    private final int num;

    public LottoNum(String num) {
        this(Integer.parseInt(num));
    }

    public LottoNum(int num) {
        this.num = num;
        validateLottoNum();
    }

    public int getValue() {
        return num;
    }

    private void validateLottoNum() {
        if (checkUnderNum() || checkOverNum()) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45까지의 숫자만 가능합니다.");
        }
    }

    private boolean checkUnderNum() {
        return this.num < Constant.MIN_NUM;
    }

    private boolean checkOverNum() {
        return this.num > Constant.MAX_NUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return num;
    }
}
