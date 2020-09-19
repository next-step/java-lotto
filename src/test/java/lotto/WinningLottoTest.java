package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;
    private static String lottoNum = "1,2,3,4,5,6";

    @BeforeEach
    void setup() {
        winningLotto = new WinningLotto(lottoNum);
    }

    @Test
    @DisplayName("당첨 번호로 로또 생성하는지")
    public void createdWinningLotto() {
        assertThat(winningLotto)
                .isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("당첨 번호 가져오는지")
    public void getWinningLotto() {
        assertThat(winningLotto.getWinningLotto().getLottoNumber()).isEqualTo(lottoNum);
    }
}
