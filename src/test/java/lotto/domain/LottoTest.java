package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void create() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();
    }
}
