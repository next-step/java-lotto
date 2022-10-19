package lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private final int FIRST = 6;
    private final int SECOND = 5;
    private final int THIRD = 4;
    private final int FORTH = 3;
    private final int ZERO = 0;

    private final BigDecimal FIRST_PRIZE = BigDecimal.valueOf(2000000000);
    private final BigDecimal SECOND_PRIZE = BigDecimal.valueOf(1500000);
    private final BigDecimal THIRD_PRIZE = BigDecimal.valueOf(50000);
    private final BigDecimal FORTH_PRIZE = BigDecimal.valueOf(5000);
    private final BigDecimal DEFAULT = BigDecimal.valueOf(0);

    private Rank rank;

    @Test
    void winner_gets_amount() {
        Rank first = rank.getRank(FIRST);
        assertThat(first.getAmount()).isEqualTo(FIRST_PRIZE);

        Rank second = rank.getRank(SECOND);
        assertThat(second.getAmount()).isEqualTo(SECOND_PRIZE);

        Rank third = rank.getRank(THIRD);
        assertThat(third.getAmount()).isEqualTo(THIRD_PRIZE);

        Rank forth = rank.getRank(FORTH);
        assertThat(forth.getAmount()).isEqualTo(FORTH_PRIZE);

        Rank zero = rank.getRank(ZERO);
        assertThat(zero.getAmount()).isEqualTo(DEFAULT);
    }
}
