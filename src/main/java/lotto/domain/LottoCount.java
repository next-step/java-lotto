package lotto.domain;

import java.text.MessageFormat;

public class LottoCount {

    public static final int ZERO_COUNT = 0;
    private final int manualCount;
    private final int randomCount;

    public LottoCount(int manualCount, int randomCount) {
        validate(manualCount, randomCount);

        this.manualCount = manualCount;
        this.randomCount = randomCount;
    }

    private void validate(int manualCount, int randomCount) {
        if (manualCount < ZERO_COUNT || randomCount < ZERO_COUNT) {
            throw new IllegalArgumentException(
                    MessageFormat.format("금액이 부족합니다. 로또 한 개 가격 : {0} 수동 로또 개수 : {1}개", LottoGame.LOTTO_PRICE, manualCount)
            );
        }
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getRandomCount() {
        return randomCount;
    }
}
