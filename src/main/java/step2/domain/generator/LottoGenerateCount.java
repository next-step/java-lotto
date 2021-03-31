package step2.domain.generator;

import step2.domain.money.Money;

public final class LottoGenerateCount {

    private final static int ZERO = 0;
    private final static int DIVIDE_STANDARD = 1000;

    private int count;

    private LottoGenerateCount(int money) {
        this.count = (money / DIVIDE_STANDARD);
    }

    public static final LottoGenerateCount of(Money money) {
        return of(money.getMoney());
    }

    public static final LottoGenerateCount of(int money) {
        return new LottoGenerateCount(money);
    }

    private final void validate(int money) {
        if(money < ZERO) {
            throw new IllegalArgumentException(); // 수정 예정
        }
    }

    public final boolean hasNext() {
        return count > ZERO;
    }

    public final void next() {
        count--;
    }
}
