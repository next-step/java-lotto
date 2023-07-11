package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottosTest {
    @Test
    void 로또_컬렉션_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lottos(0, null));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void 로또_컬렉션_구입금액_입력시_금액에_해당하는_로또_객체들_생성(int price) {
        // given
        NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lottos lottos = new Lottos(price, numberGenerator);

        // then
        assertThat(lottos.getLottos()).hasSize(price / 1_000);
    }

    @Test
    void 로또_컬렉션_숫자_생성기_주입시_해당_숫자들로_로또생성_성공() {
        // given
        int price = 1000;
        NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lottos lottos = new Lottos(price, numberGenerator);

        // then
        assertThat(lottos.getLottos().get(0)).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
