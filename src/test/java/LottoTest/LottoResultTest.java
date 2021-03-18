package LottoTest;

import lotto.LottoResult;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    @Test
    void When_New_Then_IntialMatchCountIsZero() {
        LottoResult lottoResult = new LottoResult();
        assertThat(lottoResult.winningNumberCount(0)).isEqualTo(0);
    }

    @Test
    void When_IncreaseMatchCount_Then_Increased() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.increase(0);
        assertThat(lottoResult.winningNumberCount(0)).isEqualTo(1);
    }
}
