package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("문자열을 콤마(,) 기준으로 Split을 하면 알맞게 분할되어야 한다")
    public void 문자열을_콤마_기준으로_Split을_하면_알맞게_분할되어야_한다() {
        assertThat("1,2".split(","))
                .containsExactly("1", "2");

        assertThat("1".split(","))
                .containsExactly("1");
    }
}
