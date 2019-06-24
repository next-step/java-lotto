package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrizesTest {

    @Test
    @DisplayName("당첨금 확인")
    void test_profits() {
        Prizes prizes = new Prizes(Arrays.asList(Prize.FIRST, Prize.FOURTH));
        assertThat(prizes.getProfits()).isEqualTo(2000005000);
    }
}
