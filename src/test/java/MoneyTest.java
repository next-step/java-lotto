import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void create() {
        assertThat(new Money(0)).isEqualTo(new Money());
    }
}
