package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoRaffleTest {

    @Test
    void ImmutableRaffleNumbers() {
        assertThatThrownBy(() -> {
            Set<Integer> raffleNumbers = new LottoRaffle().raffleNumbers();
            raffleNumbers.add(4);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
