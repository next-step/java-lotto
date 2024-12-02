import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void create() {
        assertThat(new Money(0)).isEqualTo(new Money());
    }

    @Test
    void invalid(){
        assertThatThrownBy(
                () -> new Money("abc")
        ).isInstanceOf(NumberFormatException.class);
    }
}
