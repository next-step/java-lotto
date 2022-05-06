package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Rank;
import lotto.model.WinnerLotto;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.LottoNumberTest.*;
import static lotto.LottoTest.TEST_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 로또 번호, 보너스 번호 저장 클래스")
public class WinnerLottoTest {

    @Test
    @DisplayName("객체 생성시 당첨 로또, 보너스 번호 입력값이 null이면 예외가 발생한다.")
    void nullTest() {
        assertThatThrownBy(() -> new WinnerLotto(null, LottoNumber.valueOf(1)))
                .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new WinnerLotto(TEST_LOTTO, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("객체 생성 시 당첨 로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    void containsTest() {
        assertThatThrownBy(() -> new WinnerLotto(TEST_LOTTO, ONE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("같을 수 없습니다.");
    }

    @Test
    @DisplayName("로또 1등 당첨 테스트")
    void rankFirstTest() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto(TEST_LOTTO, LottoNumber.valueOf(10));
        Lotto firstLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, SIX));

        // when
        Rank rank = winnerLotto.getRank(firstLotto);

        // then
        assertThat(rank == Rank.FIRST).isTrue();
    }

    @Test
    @DisplayName("로또 2등 당첨 테스트")
    void rankSecondTest() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto(TEST_LOTTO, LottoNumber.valueOf(10));
        Lotto secondLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, LottoNumber.valueOf(10)));

        // when
        Rank rank = winnerLotto.getRank(secondLotto);

        // then
        assertThat(rank == Rank.SECOND).isTrue();
    }
    @Test
    @DisplayName("로또 3등 당첨 테스트")
    void rankThirdTest() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto(TEST_LOTTO, LottoNumber.valueOf(10));
        Lotto thirdLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, LottoNumber.valueOf(45)));

        // when
        Rank rank = winnerLotto.getRank(thirdLotto);

        // then
        assertThat(rank == Rank.THIRD).isTrue();
    }

    @Test
    @DisplayName("로또 4등 당첨 테스트")
    void rankFourthTest() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto(TEST_LOTTO, LottoNumber.valueOf(10));
        Lotto fourthLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, LottoNumber.valueOf(44), LottoNumber.valueOf(45)));

        // when
        Rank rank = winnerLotto.getRank(fourthLotto);

        // then
        assertThat(rank == Rank.FOURTH).isTrue();
    }


    @Test
    @DisplayName("로또 5등 당첨 테스트")
    void rankFifthTest() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto(TEST_LOTTO, LottoNumber.valueOf(10));
        Lotto fifthLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, LottoNumber.valueOf(43), LottoNumber.valueOf(44), LottoNumber.valueOf(45)));

        // when
        Rank rank = winnerLotto.getRank(fifthLotto);

        // then
        assertThat(rank == Rank.FIFTH).isTrue();
    }

}
