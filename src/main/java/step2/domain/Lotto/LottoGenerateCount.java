package step2.domain.Lotto;

import step2.domain.InputMoney;
import step2.dto.LottoCreationRequestDto;

public final class LottoGenerateCount {

    private final static int DIVIDE_STANDARD = 1000;
    private final int FINISH = 0;
    private int count;

    private LottoGenerateCount(int money) {
        this.count = (money/DIVIDE_STANDARD);
    }

    public static final LottoGenerateCount newInstance(LottoCreationRequestDto requestDto) {
        return newInstance(requestDto.getInputMoney());
    }

    public static final LottoGenerateCount newInstance(InputMoney inputMoney) {
        return newInstance(inputMoney.getInputMoney());
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
