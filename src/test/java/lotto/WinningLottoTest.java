package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private WinningLotto winningLotto;
    private static String lottoNum = "1,2,3,4,5,6";
    private static int bonusNumber = 7;

    @BeforeEach
    void setup() {
        winningLotto = new WinningLotto(lottoNum, bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호로 로또 생성하는지")
    public void createdWinningLotto() {
        assertThat(winningLotto)
                .isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("당첨 번호랑 보너스볼이랑 중복하면 예외처리")
    public void duplicateBonusball() {
        assertThatThrownBy(() -> new WinningLotto(lottoNum, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 볼은 당첨 번호랑 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("당첨 번호 가져오는지")
    public void getWinningLotto() {
        assertThat(winningLotto.getWinningLotto().getLotto().get(0).getLottoNumber())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("보너스 번호 가져오는지")
    public void getBonusball() {
        assertThat(winningLotto.getBonusNumber().getLottoNumber())
                .isEqualTo(bonusNumber);
    }
}
