package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 로또 초기화 테스트")
    public void initializeWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 42, 29, 17, 23, 34), 6);

        assertThat(winningLotto.getLotto().size()).isEqualTo(6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 로또 당첨 숫자 비교 테스트")
    public void compareWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 42, 29, 17, 23, 34), 7);

        Lotto lotto1 = new Lotto(Arrays.asList(3, 42, 29, 16, 24, 32));
        Lotto lotto2 = new Lotto(Arrays.asList(2, 41, 30, 15, 24, 45));

        assertThat(winningLotto.compareLotto(lotto1)).isEqualTo(3);
        assertThat(winningLotto.compareLotto(lotto2)).isEqualTo(0);
    }

    @Test
    @DisplayName("보너스 숫자 비교 테스트")
    public void compareBonusNumberTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 42, 29, 17, 23, 34), 7);

        Lotto lotto = new Lotto(Arrays.asList(3, 42, 29, 16, 24, 7));

        assertThat(winningLotto.isBonusIncluded(lotto)).isTrue();
    }

    @Test
    @DisplayName("당첨 로또 초기화 - Numeric String 예외 테스트")
    public void initializeWinningLottoNumericStringErrorTest() {
        assertThatThrownBy(() -> WinningLotto.getWinningNumbers("3, 42, 29, 17, 이십삼, 34"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_NUMERIC_ERROR.getMessage());
    }

    @Test
    @DisplayName("당첨 로또 초기화 - BonusNumber 범위 예외 테스트")
    public void initializeWinningLottoBonusNumberBoundErrorTest() {
        assertThatThrownBy(() -> WinningLotto.getBonusNumber("49"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_BOUND_ERROR.getMessage());
    }
}