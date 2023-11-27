package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "4000:4"}, delimiter= ':')
    void 로또를_산다(int price, int count) {
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.buyAutoSelectedLottos(price, List.of()).size()).isEqualTo(count);
    }

    @Test
    void 로또액수가_수동선택횟수보다_많을수는_없다() {
        LottoGame lottoGame = new LottoGame();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoGame.buyAutoSelectedLottos(1000,
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6))))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 1300, 1001})
    void 금액이부족하면_로또가_사지지_않는다(int price) {
        LottoGame lottoGame = new LottoGame();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoGame.buyAutoSelectedLottos(price, List.of()));
    }

    @ParameterizedTest
    @MethodSource("manaulSelectedLottos")
    void 수동으로_로또를_산다(List<List<Integer>> manaulLottos, List<Lotto> lottos) {
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.buyManualSelectLotto(manaulLottos)).isEqualTo(lottos);
    }

    static Stream<Arguments> manaulSelectedLottos() {
        return Stream.of(
                Arguments.arguments(List.of(List.of(1, 2, 3, 4, 5, 6)), List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
                Arguments.arguments(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 3, 4, 5, 6, 8)),
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 8)))
                )
        );
    }

}
