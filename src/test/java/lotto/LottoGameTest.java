package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
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

    @ParameterizedTest
    @ValueSource(ints = {1,500,999})
    void _1000원_미만시_로또를_구매할수없음(int input) {
        assertThatThrownBy(() -> lottoGame.buyLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 비용이 부족합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000,2000})
    void _1000원_이상시_로또를_구매할수있음(int input) {
        assertThatCode(() -> lottoGame.buyLotto(input))
                .doesNotThrowAnyException();;
    }

    @Test
    void 로또당첨번호_6개아님() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        );

        assertThatThrownBy(() -> lottoGame.score(lottoNumbers, new LottoNumber(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨번호는 6개 입니다.");
    }
}
