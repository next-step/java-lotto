package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    Lottos lottos;
    Lotto winning = new Lotto(Arrays.asList(1,2,3,4,5,6));

    @BeforeEach
    void setUp() {
        Lotto first = new Lotto(Arrays.asList(1,11,12,13,14,15));
        Lotto second = new Lotto(Arrays.asList(1,2,12,13,14,15));
        Lotto third = new Lotto(Arrays.asList(1,2,3,13,14,15));
        Lotto fourth = new Lotto(Arrays.asList(1,2,12,4,14,15));
        Lotto fifth = new Lotto(Arrays.asList(1,11,12,4,5,15));
        Lotto sixth = new Lotto(Arrays.asList(1,2,3,4,14,15));
        Lotto seventh = new Lotto(Arrays.asList(1,2,3,13,5,15));
        Lotto eighth = new Lotto(Arrays.asList(1,2,3,4,5,15));
        Lotto ninth = new Lotto(Arrays.asList(1,2,3,13,5,6));
        Lotto tenth = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lottos = new Lottos(Arrays.asList(first, second, third, fourth, fifth,
                sixth, seventh, eighth, ninth, tenth));
    }

    @DisplayName("Get number of lottos which are fifth prizes")
    @Test
    void testFifthPrize() {
        assertThat(lottos.fifthPrize(winning)).isEqualTo(3);
    }

    @DisplayName("Get number of lottos which are fourth prizes")
    @Test
    void testFourthPrize() {
        assertThat(lottos.fourthPrize(winning)).isEqualTo(2);
    }

    @DisplayName("Get number of lottos which are third prizes")
    @Test
    void testThirdPrize() {
        assertThat(lottos.thirdPrize(winning)).isEqualTo(2);
    }

    @DisplayName("Get number of lottos which are first prizes")
    @Test
    void testFirstPrize() {
        assertThat(lottos.firstPrize(winning)).isEqualTo(1);
    }

    @DisplayName("Calculate profit rate of lottos")
    @Test
    void testProfitRate() {
        assertThat(lottos.profitRate(winning)).isEqualTo(200_311.5);
    }
}
