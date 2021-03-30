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

    public static final LottoGenerateCount newInstance(LottoCreationRequestDto requestDto) {
        return newInstance(requestDto.getMoney());
    }

    public static final LottoGenerateCount newInstance(Money money) {
        return newInstance(money.getMoney());
    }

    public static final LottoGenerateCount newInstance(int money) {
        return new LottoGenerateCount(money);
    }

    public final boolean hasNext() {
        return count > FINISH;
    }

    public final void next() {
        count--;
    }
}
