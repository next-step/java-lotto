package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectivesTest {

    @Test
    void 계산테스트() {
        Directives dir = new Directives(new String[]{"1", "+", "2", "-", "1"});
        assertThat(dir.calculate()).isEqualTo(2);
    }
}