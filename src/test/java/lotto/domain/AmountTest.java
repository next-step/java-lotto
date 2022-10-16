package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    void create() {
        Amount actual = new Amount(3);

        Assertions.assertThat(actual).isEqualTo(new Amount(3));
    }
}
