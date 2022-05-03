import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    String line;

    @BeforeEach
    void setUp() {
        line = "3 + 5 / 2 * 3";
    }

    @Test
    public void 문자열로_식을_입력했을때_계산_전체_프로세스_확인() {
        assertThat(Main.calculateInput(line)).isEqualTo(12);
    }
}