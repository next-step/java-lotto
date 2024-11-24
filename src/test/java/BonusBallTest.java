import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {
    @Test
    void create() {
        assertThat(new BonusBall(7)).isEqualTo(new BonusBall(7));
    }

    @Test
    void invalid() {
        assertThatThrownBy(
                () -> new BonusBall(Constants.MIN_LOTTO_NUMBER - 1)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> new BonusBall(Constants.MAX_LOTTO_NUMBER + 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
