package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    void create() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
    }
}
