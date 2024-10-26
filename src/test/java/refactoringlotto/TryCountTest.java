package refactoringlotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TryCountTest {

    public static final int PURCHASE_AMOUNT = 5000;
    public static final int TRY_COUNT = 5;

    @Test
    void 금액_개수변환테스트() {
        TryCount tryCount = TryCount.initTryCount(PURCHASE_AMOUNT);
        assertThat(tryCount).isEqualTo(new TryCount(TRY_COUNT));
    }


}