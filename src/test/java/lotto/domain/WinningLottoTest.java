package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 로또 초기화 테스트")
    public void initializeWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto("3, 42, 29, 17, 23, 34");

        assertThat(winningLotto.getLotto().length).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 로또 당첨 숫자 비교 테스트")
    public void compareWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto("3, 42, 29, 17, 23, 34");
        Lotto lotto1 = new Lotto(new Integer[]{3, 42, 29, 16, 24, 32});
        Lotto lotto2 = new Lotto(new Integer[]{2, 41, 30, 15, 24, 45});

        assertThat(winningLotto.compareLotto(lotto1)).isEqualTo(3);
        assertThat(winningLotto.compareLotto(lotto2)).isEqualTo(0);
    }

    @Test
    @DisplayName("당첨 로또 초기화 - Numeric String 예외 테스트")
    public void initializeWinningLottoNumericStringErrorTest() {
        assertThatThrownBy(() -> new WinningLotto("3, 42, 29, 17, 이십삼, 34"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 숫자만 입력할 수 있습니다.");

    }

}