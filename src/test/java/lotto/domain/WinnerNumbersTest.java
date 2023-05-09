package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinnerNumbersTest {

    @Test
    void 당첨번호_매칭개수_확인() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        WinnerNumbers winnerNumbers = new WinnerNumbers("1,2,3,4,10,11");
        int actual = winnerNumbers.matchCount(lotto);
        assertThat(actual).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 숫자_6개_아닌경우_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerNumbers(value));
    }
}
