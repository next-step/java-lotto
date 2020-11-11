import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    @DisplayName("정상적인 Number객체 생성")
    void createNumber() {
        String numStr = "1";

        Number number = new Number(numStr);

        assertThat(number).isEqualTo(new Number(numStr));
    }
}
