package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void toStringTest() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto).hasToString("[1, 2, 3, 4, 5, 6]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 숫자_6개_아닌경우_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(value));
    }
}
