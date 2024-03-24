package lotto.domain;

import static lotto.domain.grade.Grade.FIRST_GRADE;
import static org.assertj.core.api.Assertions.*;

import lotto.domain.grade.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeTest {

    @ParameterizedTest
    @CsvSource(value = {"6:True", "5:False"}, delimiter = ':')
    @DisplayName("correctingCount가 같을 경우 참을, 아닐 경우 거짓을 반환한다")
    public void Garde_Should_Return_True_If_test_correcting_count_equality(int input, boolean expected){
        assertThat(FIRST_GRADE.isSameCorrectingCount(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("맞춘 로또 번호 개수가 전달될 경우 Grade로 변경되어야 한다.")
    public void Grade_Should_Conversion_From_CorrectingCount(){
        assertThat(Grade.fromCorrectingCount(6)).isEqualTo(FIRST_GRADE);
    }
}