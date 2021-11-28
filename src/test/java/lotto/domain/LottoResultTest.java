package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("LottoResult 생성자 테스트")
    public void constructor() {
        assertThat(new LottoResult())
                .isEqualTo(new LottoResult());
    }
}
