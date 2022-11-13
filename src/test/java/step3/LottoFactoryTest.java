package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    @Test
    @DisplayName("자동 추첨 결과")
    void makeResult() {
        LottoFactory lotto = new LottoFactory();
        assertThat(lotto.getRandomLotto().size()).isEqualTo(6);
    }
}
