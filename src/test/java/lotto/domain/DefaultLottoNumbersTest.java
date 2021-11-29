package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoNumbersTest {
    @Test
    @DisplayName("DefaultLottoNumbers 생성자 테스트")
    void constructor() {
        assertThat(new DefaultLottoNumbers()).isEqualTo(new DefaultLottoNumbers());
    }
}
