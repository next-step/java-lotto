package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GradeTest {

    @DisplayName("일치하는 개수에 맞게 등급을 반환한다.")
    @ParameterizedTest(name = "[{index}] matchCount: {0}, expected: {1}")
    @CsvSource(value = {
            "6, FIRST",
            "5, SECOND",
            "4, THIRD",
            "3, FOURTH",
            "2, BANG",
            "0, BANG",
            "-1, BANG"
    })
    void from(int matchCount, Grade expectedGrade) {
        assertThat(Grade.from(matchCount)).isEqualTo(expectedGrade);
    }

}
