package lotto.domain;

import static lotto.domain.grade.Grade.BONUS_GRADE;
import static lotto.domain.grade.Grade.FIRST_GRADE;
import static lotto.domain.grade.Grade.UN_LUCKY_GRADE;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.grade.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GradeTest {

    @ParameterizedTest
    @CsvSource(value = {"6:True", "5:False"}, delimiter = ':')
    @DisplayName("correctingCount가 같을 경우 참을, 아닐 경우 거짓을 반환한다")
    public void Garde_Should_Return_True_If_test_correcting_count_equality(int input,
        boolean expected) {
        assertThat(FIRST_GRADE.isSameCorrectingCount(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("맞춘 로또 번호 개수가 전달될 경우 Grade로 변경되어야 한다.")
    public void Grade_Should_Conversion_From_CorrectingCount() {
        assertThat(Grade.from(6, false)).isEqualTo(FIRST_GRADE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("맞춘 로또 번호 개수가 0, 1, 2 일 경우 UN_LUCKY_GRADE가 반환되어야 한다.")
    public void Grade_Should_Conversion_From_CorrectingCount_To_Un_Lucky_Grade(int input) {
        assertThat(Grade.from(input, false)).isEqualTo(UN_LUCKY_GRADE);
    }

    @Test
    @DisplayName("맞춘 로또 번호 개수가 5개이면서 보너스 번호도 맞췄다면 BONUS_GRADE가 반환되어야 한다.")
    public void Grade_Should_Conversion_From_CorrectingCount_To_Bonus_Grade() {
        assertThat(Grade.from(5, true)).isEqualTo(BONUS_GRADE);
    }
}
