package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {


    @Test
    @DisplayName("더하기")
    public void numberTest() {
        Number six = new Number(6);
        Number three = new Number(3);
        Number nine = six.add(three);

        assertThat(nine).isEqualTo(new Number(9));
    }

    @Test
    @DisplayName("같은 Number인지 확인")
    public void equality() {
        assertThat(new Number(5)).isEqualTo(new Number(5));
    }
}
