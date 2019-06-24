package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrizesTest {

    @Test
    void total() {
        Prizes prizes = new Prizes(Arrays.asList(Prize.FIRST, Prize.FOURTH));
        assertThat(prizes.total()).isEqualTo(2000005000);
    }
}
