package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameServiceTest {
    @Test
    @DisplayName("LottoGameService 생성자 테스트")
    public void constructor() {
        assertThat(new LottoGameService()).isEqualTo(new LottoGameService());
    }
}
