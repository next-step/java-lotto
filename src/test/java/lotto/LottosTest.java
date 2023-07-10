package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottosTest {
    @Test
    void 로또_컬렉션_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lottos(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000,2000})
    void 로또_컬렉션_구입금액_입력시_금액에_해당하는_로또_객체들_생성(int price) {
        // when
        Lottos lottos = new Lottos(price);

        // then
        assertThat(lottos.getList()).hasSize(price / 1_000);
    }
}
