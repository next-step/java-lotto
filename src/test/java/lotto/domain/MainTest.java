package lotto.domain;

import lotto.Main;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {
    @Test
    void 계산_순서_테스트() {
        assertThat(Main.run("2 + 3 * 4 / 2")).isEqualTo(new Number(10));
    }
}
