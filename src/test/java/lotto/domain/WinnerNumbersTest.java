package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class WinnerNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 숫자_6개_아닌경우_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerNumbers(value));
    }

    @Test
    void 로또_당첨_결과_확인() {
        WinnerNumbers winnerNumbers = new WinnerNumbers("1,2,3,4,5,6");
        Lotto matchOne = new Lotto("1,41,42,43,44,45");
        Lotto matchThree = new Lotto("1,2,3,43,44,45");
        Lotto matchFive = new Lotto("1,2,3,4,5,45");
        List<Lotto> lottos = List.of(matchOne, matchThree, matchFive);
        assertThatNoException().isThrownBy((() -> winnerNumbers.matchLottos(lottos)));
    }
}
