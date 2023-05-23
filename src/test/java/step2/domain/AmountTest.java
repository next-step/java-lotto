package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    @DisplayName("금액 객체 생성")
    void amount() {
        assertThat(new Amount(14000)).isEqualTo(new Amount(14000));
    }
}
