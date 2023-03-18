package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGradeTest {

    @DisplayName("1등 확인")
    @Test
    void testFirstGrade() {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(6, false);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FIRST);
    }
    @DisplayName("2등 확인")
    @Test
    void testSecondGrade() {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(5, true);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.SECOND);
    }
    @DisplayName("3등 확인")
    @Test
    void testThirdGrade() {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(5, false);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.THIRD);
    }
    @DisplayName("4등 확인")
    @Test
    void testFourthGrade() {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(4, false);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FOURTH);
    }

    @DisplayName("4등 확인(보너스볼 일치)")
    @Test
    void testFourthHasBonusBallGrade() {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(4, true);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FOURTH);
    }

    @DisplayName("5등 확인")
    @Test
    void testFifthGrade() {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(3, false);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FIFTH);
    }

    @DisplayName("미당첨 확인")
    @ParameterizedTest
    @ValueSource(longs={0, 1, 2})
    void testNoneGrade(long matchCount) {
        LottoGrades.LottoGrade actual = LottoGrades.getLottoGrade(matchCount, true);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.NONE);
    }


}