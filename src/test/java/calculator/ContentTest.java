package calculator;

import calculator.domain.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContentTest {

    @Test
    @DisplayName("Content의 필드가 같으면, 동등성 테스트를 통과한다.")
    void test() {
        assertThat(new Content(3)).isEqualTo(new Content(3));
        assertThat(new Content(2)).isNotEqualTo(new Content(3));
        assertThat(new Content("+")).isEqualTo(new Content("+"));
        assertThat(new Content("-")).isNotEqualTo(new Content("/"));
    }
}
