package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    void price() {
        assertThat(new Price(1000)).isEqualTo(new Price(1000));
    }

}
