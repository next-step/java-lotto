package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1. 숫자를 출력한다.
 */
public class OutputViewTest {
    @DisplayName("숫자를 입력받아 출력한다.")
    @Test
    void print_result() {
        OutputView outputView = new OutputView(3.12345);
        assertThat(outputView.print2()).isEqualTo("3.12");
    }
}
