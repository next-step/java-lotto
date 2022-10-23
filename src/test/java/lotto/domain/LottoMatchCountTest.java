package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMatchCountTest {

    @Test
    void create() {
        LottoMatchCount actual = new LottoMatchCount(1);

        assertThat(actual).isEqualTo(new LottoMatchCount(1));
    }

    @Test
    void valid() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoMatchCount(-1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoMatchCount(7)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
