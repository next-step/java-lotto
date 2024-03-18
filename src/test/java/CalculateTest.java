import domain.Calculate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateTest {

    @Test
    @DisplayName("null이나 빈 문자열이라면 예외")
    void null_or_empty(){
        assertThatThrownBy(() -> {
            Calculate.process(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Calculate.process("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void plus(){
        final String input = "1 + 2";
        int result = Calculate.process(input);
        assertThat(result).isEqualTo(3);
    }
}
