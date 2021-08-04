package app.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("돈 객체는 양수만 가능하다.")
    @Test
    void IsOnlyPositive(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> Money.of(-1000)
        ).withMessageContaining("Error");
    }
}