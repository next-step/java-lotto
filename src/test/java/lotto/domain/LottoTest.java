package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,true", "6,true", "7,false", "10,false"})
    void hasNumber(int value, boolean expect) {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        boolean actual = lotto.hasNumber(new LottoNumber(value));
        assertThat(actual).isEqualTo(expect);
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
