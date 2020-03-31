package lotto;
import static org.assertj.core.api.Assertions.*;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @Test
    void increaseResultTest() {
        LottoResult result = new LottoResult();
        for(int i =0; i < 10; i++) {
            result.increase(LottoPrize.FIRST);
        }
        assertThat(result.prizeCount(LottoPrize.FIRST)).isEqualTo(10);
    }
}
