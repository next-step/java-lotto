package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("ofSource")
    @DisplayName("맞은 번호에 따라 상금을 리턴할 수 있는지")
    void of(int hitCount, Prize result) {
        assertThat(Prize.of(hitCount)).isEqualTo(result);
    }

    static Stream<Arguments> ofSource() {
        return Stream.of(
                Arguments.of(6, FIRST),
                Arguments.of(5, SECOND),
                Arguments.of(4, THIRD),
                Arguments.of(3, FOURTH),
                Arguments.of(2, FIFTH),
                Arguments.of(1, SIXTH),
                Arguments.of(0, LOSE)
        );
    }
}
