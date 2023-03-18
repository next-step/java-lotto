package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoPromoterTest {

    private LottoPromoter promoter = new LottoPromoter();

    @Test
    void checkLottoFirstGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        Lotto winninLotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrades.LottoGrade actual = promoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FIRST);
    }

    @Test
    void checkLottoSecondGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(7)));
        Lotto winninLotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrades.LottoGrade actual = promoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.SECOND);
    }

    @Test
    void checkLottoThirdGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(8)));
        Lotto winninLotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrades.LottoGrade actual = promoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.THIRD);
    }

    @Test
    void checkLottoFourthGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(8), new LottoBall(10)));
        Lotto winninLotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrades.LottoGrade actual = promoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FOURTH);
    }

    @Test
    void checkLottoFifthGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(8), new LottoBall(10), new LottoBall(20)));
        Lotto winninLotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrades.LottoGrade actual = promoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.FIFTH);
    }

    @Test
    void checkLottoNoneGradeTest() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(7), new LottoBall(11), new LottoBall(12), new LottoBall(13)));
        Lotto winninLotto = new Lotto(Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6)));
        LottoBall bonusBall = new LottoBall(7);

        LottoGrades.LottoGrade actual = promoter.checkLottoGrade(lotto, winninLotto, bonusBall);
        assertThat(actual).isEqualTo(LottoGrades.LottoGrade.NONE);
    }

    @DisplayName("유효한 로또 반환 테스트")
    @Test
    void buyLottoTest() {
        Lotto actual = promoter.buyLotto();
        assertThat(actual.getBalls().size()).isEqualTo(6);
    }
    
    @DisplayName("유효한 금액 입력 시 로또 갯수 반환 확인")
    @Test
    void validGetLottoCountTest() {
        int money = 14000;
        
        int actual = promoter.getLottoCount(money);
        assertThat(actual).isEqualTo(14);
    }
    
    @DisplayName("유효하지 않은 금액 입력 시 예외 발생 확인")
    @Test
    void invalidGetLottoCountTest() {
        int money = 200;
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                promoter.getLottoCount(money));
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void buyLottosTest() {
        int money = 2200;
        List<Lotto> actuals = promoter.buyLottos(money);
        assertThat(actuals.size()).isEqualTo(2);
    }
    
    @DisplayName("로또 목록 등수 확인 테스트")
    @Test
    void checkLottoGradeTest() {
        List<Lotto> lottos = Arrays.asList(promoter.createLotto(Arrays.asList(1,2,3,4,5,6)));
        Lotto winningLotto = promoter.createLotto(Arrays.asList(1,2,3,4,5,6));
        LottoBall bonusBall = new LottoBall(40);

        Map<LottoGrades.LottoGrade, Integer> actual = promoter.checkLottoGrades(lottos, winningLotto, bonusBall);
        assertTrue(actual.get(LottoGrades.LottoGrade.FIRST) == 1);
        
    }

}