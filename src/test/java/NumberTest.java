import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 숫자_외_문자가_들어온경우_예외발생() {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Number("cdc");
            });
    }
}
