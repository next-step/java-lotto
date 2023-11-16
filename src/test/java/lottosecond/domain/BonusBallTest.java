package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;
import lottosecond.testutil.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusBallTest {

    @ParameterizedTest(name = "1 ~ 45 이외의 숫자는 보너스 볼로 들어올 수 없습니다.")
    @ValueSource(ints = {0, 46})
    void invalidNumber(int ballNumber) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BonusBall(ballNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 범위는 1 ~ 45 범위만 가능합니다.");
    }

    @DisplayName("전달받은 지난주 당첨번호와 중복된 숫자가 존재하면 안됩니다.")
    @Test
    void duplicatedNumberWithWinningLotto() {
        // given
        Lotto lotto = new Lotto(TestUtil.makeLottoNumberSet(1, 2, 3, 4, 5, 6));
        // when
        BonusBall bonusBall = new BonusBall(6);
        // then
        assertThat(bonusBall.isDuplicateWithLastWinningLottoNumber(lotto)).isTrue();
    }

    @DisplayName("전달받은 지난주 당첨번호와 중복된 숫자가 없다면 true 입니다.")
    @Test
    void notDuplicatedNumber() {
        // given
        Lotto lotto = new Lotto(TestUtil.makeLottoNumberSet(1, 2, 3, 4, 5, 6));
        // when
        BonusBall bonusBall = new BonusBall(7);
        // then
        assertThat(bonusBall.isDuplicateWithLastWinningLottoNumber(lotto)).isFalse();
    }

}