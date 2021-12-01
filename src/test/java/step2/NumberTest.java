package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Number;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    @DisplayName("String을 사용한 생성자 테스트")
    void createFromString() {
        assertThat(Number.createFromString("2")).isEqualTo(Number.createFromString("2"));
        assertThat(Number.createFromString("2")).isEqualTo(Number.createFromInt(2));
        assertThat(Number.createFromString("2")).isNotEqualTo(Number.createFromString("1"));
    }

    @Test
    @DisplayName("int를 사용한 생성자 테스트")
    void createFromInt() {
        assertThat(Number.createFromInt(1)).isEqualTo(Number.createFromInt(1));
        assertThat(Number.createFromInt(2)).isNotEqualTo(Number.createFromInt(1));
    }
}
