package lotto.step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest(name = "creationTest")
    @ValueSource(strings = {"0","500","950"})
    public void creationTest(String input) {
        assertThatThrownBy(() -> new Money(input) )
                .isInstanceOf(IllegalArgumentException.class);
    }

}
