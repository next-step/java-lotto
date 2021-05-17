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

    @Test
    @DisplayName("substring을 하여 인덱스를 기준으로 자를 수 있다.")
    public void substring을_하여_인덱스를_기준으로_자를_수_있다() {
        assertThat("(1,2)".substring(1,4))
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 함수를 통해 원하는 위치의 문자열을 가져와야 한다")
    public void charAt_함수를_통해_원하는_위치의_문자열을_가져와야_한다() {
        assertThat("abc".charAt(1))
                .isEqualTo('b');
    }
}
