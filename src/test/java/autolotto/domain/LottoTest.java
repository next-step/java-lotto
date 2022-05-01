package autolotto.domain;

import autolotto.domain.Lotto;
import autolotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4 ,5, 6:6",
            "1, 2, 3, 4, 5, 43:5",
            "1, 2, 3, 4, 41, 42:4"
    }, delimiter = ':')
    void winningLottoGiven_ReturnMatchCount(String number, int matchCount) {
        assertThat(lotto.match(new WinningLotto(number))).isEqualTo(matchCount);
    }
}
