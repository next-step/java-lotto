package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {

    @Test
    void create() {
        LottoCount actual = new LottoCount(1);

        assertThat(actual).isEqualTo(new LottoCount(1));
    }

    @Test
    void valid() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoCount(-1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoCount(7)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
