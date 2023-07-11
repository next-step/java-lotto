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
    @ValueSource(ints = {1, 5})
    void 로또_컬렉션_개수_입력시_해당_개수의_로또_객체들_생성(int size) {
        // given
        NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lottos lottos = new Lottos(size, numberGenerator);

        // then
        assertThat(lottos.getLottos()).hasSize(size);
    }

    @Test
    void 로또_컬렉션_숫자_생성기_주입시_해당_숫자들로_로또생성_성공() {
        // given
        int size = 10;
        NumbersGenerator numberGenerator = new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lottos lottos = new Lottos(size, numberGenerator);

        // then
        assertThat(lottos.getLottos().get(0)).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
