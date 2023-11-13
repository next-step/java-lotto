package lottoauto.controller;

import lottoauto.domain.aggregate.Aggregator;
import lottoauto.domain.aggregate.WinnerBoard;
import lottoauto.domain.lotto.Lotto;
import lottoauto.domain.lotto.Lottos;
import lottoauto.domain.lotto.LottosMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        WinnerBoard winnerBoard = new WinnerBoard();
        Aggregator aggregator = new Aggregator();

        lottoController = new LottoController(aggregator, lottos, winnerBoard);
    }

    @Test
    @DisplayName("당첨 로또 번호 입력 값에는 6개의 숫자가 있어야 합니다.")
    void sizeSix() {
        // given
        // when
        // then
        assertThatThrownBy(() -> lottoController.checkWinnerLotto("4, 5, 6, 7, 8, 9, 10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호는 6개의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 로또 번호 입력 값에는 중복된 숫자가 있으면 안됩니다.")
    void duplicate() {
        // given
        // when
        // then
        assertThatThrownBy(() -> lottoController.checkWinnerLotto("4, 5, 6, 7, 8, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 당첨번호를 작성할 수 없습니다.");
    }

    @ParameterizedTest(name = "전달받은 당첨 번호 중에 1보다 작거나 45보다 큰 수가 있으면 안됩니다.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "46, 1, 2, 3, 4, 5"})
    void notValidNumber(String winNumbersString) {
        // given
        // when
        // then
        assertThatThrownBy(() -> lottoController.checkWinnerLotto(winNumbersString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적절하지 않은 당첨 번호 입니다.");
    }

}