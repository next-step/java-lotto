package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusBallTest {

    @Test
    void getBonusNumber() {
        Assertions.assertThat(new BonusBall("10").getBonusNumber()).isEqualTo(10);
    }

    @Test
    void getBonusNumberValid() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusBall("999"));
    }
}