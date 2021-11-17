package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    @DisplayName("각 등수에 대한 정보를 static 하게 사용할 수 있다.")
    void 상금생성() {
        assertThat(FIRST).isEqualTo(FIRST);
        assertThat(SECOND).isEqualTo(SECOND);
        assertThat(THIRD).isEqualTo(THIRD);
        assertThat(FOURTH).isEqualTo(FOURTH);
    }

    @Test
    @DisplayName("각 등수는 순서를 갖는다.")
    void 상금순위() {
        assertThat(FIRST).isGreaterThan(SECOND);
        assertThat(SECOND).isGreaterThan(THIRD);
        assertThat(THIRD).isGreaterThan(FOURTH);
        assertThat(FOURTH).isGreaterThan(FIFTH);
        assertThat(FIFTH).isGreaterThan(SIXTH);
        assertThat(SIXTH).isGreaterThan(LOSE);
    }
}
