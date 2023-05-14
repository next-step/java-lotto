package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(
                new Lottos(
                        new ArrayList<>(),
                        new LottoNumberGenerator())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 500, 999})
    void _1000원_미만시_로또를_구매할수없음(int input) {
        assertThatThrownBy(() -> lottoGame.buyLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 비용이 부족합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void _1000원_이상시_로또를_구매할수있음(int input) {
        assertThatCode(() -> lottoGame.buyLotto(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또당첨번호_6개아님_숫자3개입력() {
        assertThatThrownBy(() -> new WinningNumbers(
                List.of(1, 2, 3),
                4
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨번호는 6개 입니다.");
    }

    @Test
    void 이미존재하는_보너스번호_입력() {
        assertThatThrownBy(() -> new WinningNumbers(
                List.of(1, 2, 3, 4, 5, 6),
                1
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 번호입니다.");
    }

    @Test
    void 중복된_로또번호_입력() {
        assertThatThrownBy(() -> new WinningNumbers(
                List.of(1, 1, 3, 4, 5, 6),
                7
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 입력되었습니다.");
    }

}
