import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringElementsTest {
    private StringElements elements;

    @BeforeEach
    public void setUp() {
        elements = new StringElements();
    }


    @DisplayName("음수 값이 입력되는 경우 예외가 발생합니다.")
    @Test
    public void testNegativeValue() {
        assertThatIllegalArgumentException().isThrownBy(() -> elements.add("-1"));
    }

    @DisplayName("수의 합이 6이 되어야 합니다.")
    @Test
    public void testSum() {
        elements.add("1");
        elements.add("2");
        elements.add("3");
        assertThat(elements.sum()).isEqualTo(6);
    }
}
