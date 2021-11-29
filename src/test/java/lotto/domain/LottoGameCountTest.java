package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameCountTest {
    @Test
    @DisplayName("LottoGameCount 생성자 테스트")
    void constructor() {
        assertThat(new LottoGameCount(10)).isEqualTo(new LottoGameCount(10));
    }
}
