package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(
                new LottoNumberGenerator(),
                new ArrayList<>()
        );
    }

    @Test
    void 로또를_구매할수없음() {
        assertThatThrownBy(() -> lottoGame.buyLotto(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 비용이 부족합니다.");
    }

    @Test
    void 로또당첨번호_6개아님() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        );

        assertThatThrownBy(() -> lottoGame.score(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨번호는 6개 입니다.");
    }
}
