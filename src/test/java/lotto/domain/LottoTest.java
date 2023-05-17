package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    void matchCount() {
        Lotto lotto1 = new Lotto("1,2,3,4,5,6");
        Lotto lotto2 = new Lotto("1,2,3,4,5,6");
        int matchCount = lotto1.matchCount(lotto2);
        assertThat(matchCount).isEqualTo(6);
    }

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
