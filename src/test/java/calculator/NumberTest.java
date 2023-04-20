package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    void Number_생성() {
        int num = new Number("1");
        assertThat(num).isEqualTo(1);
    }
}
