package step2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void 생성() {
        Amount amount = Amount.of(10);
        assertThat(amount).isEqualTo(Amount.of(10));
    }
}
