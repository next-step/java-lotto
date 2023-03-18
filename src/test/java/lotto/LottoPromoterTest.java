package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPromoterTest {

    @Test
    void checkLottoFirstGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto winninLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrade.LOTTO_GRADE actual = LottoPromoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.FIRST);
    }

    @Test
    void checkLottoSecondGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto winninLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrade.LOTTO_GRADE actual = LottoPromoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.SECOND);
    }

    @Test
    void checkLottoThirdGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        Lotto winninLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrade.LOTTO_GRADE actual = LottoPromoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrade.LOTTO_GRADE.THIRD);
    }

}