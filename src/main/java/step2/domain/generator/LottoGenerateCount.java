package step2.domain.generator;

import step2.domain.request.Money;
import step2.dto.LottoCreationRequestDto;

public final class LottoGenerateCount {

    private final static int FINISH = 0;
    private final static int DIVIDE_STANDARD = 1000;

    private int count;

    private LottoGenerateCount(int money) {
        this.count = (money / DIVIDE_STANDARD);
    }

    public static final LottoGenerateCount of(LottoCreationRequestDto requestDto) {
        return of(requestDto.getMoney());
    }

    public static final LottoGenerateCount of(Money money) {
        return of(money.getMoney());
    }

    public static final LottoGenerateCount of(int money) {
        return new LottoGenerateCount(money);
    }

    public final boolean hasNext() {
        return count > FINISH;
    }

    public final void next() {
        count--;
    }
}
