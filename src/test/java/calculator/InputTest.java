package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class InputTest {

    @Test
    void isEmpty() {
        Input input1 = new Input("");
        assertThat(input1.isEmpty()).isTrue();

        Input input2 = new Input(null);
        assertThat(input2.isEmpty()).isTrue();
    }
}
