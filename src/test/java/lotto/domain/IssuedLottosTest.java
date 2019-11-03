package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuedLottosTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void 발급된_로또_당첨_확인(final int matchedNumbersCount) {
        IssuedLottos issuedLottos = new IssuedLottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 40, 41)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
                )
        );

        MatchedNumbers matchedNumbers = issuedLottos.checkNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(matchedNumbers.get(matchedNumbersCount)).isEqualTo(1);
    }
}
