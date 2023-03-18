package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGradeTest {

    @DisplayName("1등 확인")
    @Test
    void testFirstGrade() {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(6, false);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.FIRST);
    }
    @DisplayName("2등 확인")
    @Test
    void testSecondGrade() {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(5, true);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.SECOND);
    }
    @DisplayName("3등 확인")
    @Test
    void testThirdGrade() {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(5, false);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.THIRD);
    }
    @DisplayName("4등 확인")
    @Test
    void testFourthGrade() {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(4, false);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.FOURTH);
    }

    @DisplayName("4등 확인(보너스볼 일치)")
    @Test
    void testFourthHasBonusBallGrade() {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(4, true);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.FOURTH);
    }

    @DisplayName("5등 확인")
    @Test
    void testFifthGrade() {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(3, false);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.FIFTH);
    }

    @DisplayName("미당첨 확인")
    @ParameterizedTest
    @ValueSource(longs={0, 1, 2})
    void testNoneGrade(long matchCount) {
        LottoGrade.LOTTO_GRADE actual = LottoGrade.getLottoGrade(matchCount, true);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.NONE);
    }


}