package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"45:6", "100:5", "25:7"}, delimiter = ':')
    public void testClassInitialize(int lottoDrawLimit, int lottoMaxLimit) {

        // ready
        LottoGame lottoGame = new LottoGame();
        List<Integer> lottoGameNumbers = lottoGame.getLottoGameNumbers();

        Lotto lotto = Lotto.of(lottoMaxLimit, lottoGameNumbers);

        assertThat(lotto.getNumbers().size()).isEqualTo(lottoDrawLimit);

    }

}
