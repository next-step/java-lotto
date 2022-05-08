package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GradeTest {

    @Test
    @DisplayName("로또 2등 테스트")
    void second() {
        Grade second = Grade.SECOND;
        assertThat(second.isSecond()).isTrue();
    }


    @ParameterizedTest(name = "일치횟수 : {0}, 보너스 여부 : {1} 결과 : {2}")
    @MethodSource("lottoCountAndGrade")
    @DisplayName("로또 결과를 테스트한다.")
    void valueOf(int count, boolean isBonus, Grade grade) {
        assertThat(Grade.valueOf(count, isBonus)).isEqualTo(grade);
    }

    static Stream<Arguments> lottoCountAndGrade() {
        return Stream.of(
                Arguments.arguments(6, false, Grade.FIRST),
                Arguments.arguments(6, true, Grade.FIRST),
                Arguments.arguments(5, true, Grade.SECOND),
                Arguments.arguments(5, false, Grade.THIRD),
                Arguments.arguments(4, false, Grade.FOURTH),
                Arguments.arguments(3, true, Grade.FIFTH),
                Arguments.arguments(0, true, Grade.NONE)
        );
    }
}