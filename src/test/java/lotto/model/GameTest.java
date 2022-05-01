package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    @DisplayName("1000원 미만 입력 시 예외처리")
    void buyException() {
        assertThatThrownBy(() -> new Game().buyLotto(999)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동 로또 구매")
    void buyLotto() {
        assertThat(new Game().buyLotto(14000)).hasSize(14);
    }

    @Test
    @DisplayName("최종 수익률 확인")
    void result() {
        Game game = new Game();
        game.buyLotto(1000000);

        List<Number> beforeLottoNumber = IntStream
                .range(1, 7)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
        Lotto beforeLotto = new Lotto().draw(beforeLottoNumber);

        assertThat(game.result(beforeLotto)).isLessThan(1.0);
    }
}