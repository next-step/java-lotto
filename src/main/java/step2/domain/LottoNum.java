package step2.domain;

public class LottoNum {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    private final int num;

    public LottoNum(int num) {
        this.num = num;
        validateLottoNum();
    }

    private void validateLottoNum() {
        if (checkUnderNum() || checkOverNum()) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45까지의 숫자만 가능합니다.");
        }
    }

    private boolean checkUnderNum() {
        return this.num < MIN_NUM;
    }

    private boolean checkOverNum() {
        return this.num > MAX_NUM;
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
