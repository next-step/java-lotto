package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    @DisplayName("")
    public void issueLottoTest(int input, int expect) {
        Lotto lotto = LottoGame.issueLotto(input);

        assertThat(lotto.size()).isEqualTo(expect);
    }
}
