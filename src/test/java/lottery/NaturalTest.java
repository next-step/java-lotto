package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NaturalTest {
    @Test
    public void throwsErrorWhenNegative() {
        assertThatThrownBy(() -> new Natural(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative amount given");
    }
}
