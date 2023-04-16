package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void isEmpty() {
        assertThat(" ".isEmpty()).isFalse();
    }

    @Test
    void isBlank() {
        assertThat(" ".isBlank()).isTrue();
    }

}
