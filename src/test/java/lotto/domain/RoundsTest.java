package lotto.domain;

import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RoundsTest {

    private static final int COUNT = 5;

    @Test
    void round_count_test() {
        // Given
        LottoStrategy strategy = new AutoLotto();

        // When
        Rounds rounds = new Rounds(strategy, COUNT);

        // Then
        assertThat(rounds.getLottoList().size()).isEqualTo(COUNT);
    }

}