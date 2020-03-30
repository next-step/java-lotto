package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {14})
    void testLottoGames(final int lottoCount) {
        Lotto lotto = new Lotto(lottoCount);
        assertThat(lotto.generateLottos()).hasSize(14);
    }
}
