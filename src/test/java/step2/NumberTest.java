package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Number;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertThat(new Number(1)).isEqualTo(new Number(1));
        assertThat(new Number(2)).isNotEqualTo(new Number(1));
    }
}
