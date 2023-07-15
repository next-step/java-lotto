package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.LottoFixture.createLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 볼이 중복되면 예외를 던진다.")
    void 당첨_번호_보너스볼_중복_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusBall = 7;

        // when then
        assertThatCode(() -> new WinningLotto(numbers, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 볼은 중복 되지 않으면 WinningLotto 을 생성할 수 있다.")
    void 당첨_번호_보너스볼_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusBall = 11;

        // when , then
        assertThatCode(() -> new WinningLotto(numbers, bonusBall))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호와 구매한 로또 번호 비교")
    void 당첨_번호로_비교() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto purchasedLotto = createLotto(1, 2, 3, 4, 5, 6);

        // when
        Rank rank = winningLotto.matchOfRank(purchasedLotto);

        // then
        assertThat(rank).isEqualTo(Rank.SIX);
    }

}
