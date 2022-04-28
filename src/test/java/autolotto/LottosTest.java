package autolotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
        lottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Set.of(1, 2, 3, 4, 5, 43)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6:1",
            "5:1",
            "4:0",
            "3:0"
    }, delimiter = ':')
    void winningLottoGiven_ReturnResult(int numberOfWins, int winners) {
        Results results = lottos.confirm(new WinningLotto("1, 2, 3, 4, 5, 6"));
        assertThat(results.find(numberOfWins).get().getWinners()).isEqualTo(winners);
    }
}
