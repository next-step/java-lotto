package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    public void 숫자_생성() {
        assertThat(new Number("1")).isEqualTo(new Number(1));
    }
}
