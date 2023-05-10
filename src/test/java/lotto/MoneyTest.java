package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    @Test
    @DisplayName("Money_예외_테스트")
    public void Money_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(-1);
        });
    }

}
