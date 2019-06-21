package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class StringNumberTest {

    @Test
    void parse() {
        StringNumber number = new StringNumber("1");
        assertThat(number.parse()).isEqualTo(1);
    }

}