package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static domain.Prize.resetPrize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    public static final Lotto winning = new Lotto(Arrays.asList(1,2,3,4,5,6));
    public static final Lotto first = new Lotto(Arrays.asList(1,11,12,13,14,15));
    public static final Lotto second = new Lotto(Arrays.asList(1,2,12,13,14,15));
    public static final Lotto third = new Lotto(Arrays.asList(1,2,3,13,14,15));
    public static final Lotto fourth = new Lotto(Arrays.asList(1,2,12,4,14,15));
    public static final Lotto fifth = new Lotto(Arrays.asList(1,11,12,4,5,15));
    public static final Lotto sixth = new Lotto(Arrays.asList(1,2,3,4,14,15));
    public static final Lotto seventh = new Lotto(Arrays.asList(1,2,3,13,5,15));
    public static final Lotto eighth = new Lotto(Arrays.asList(1,2,3,4,5,15));
    public static final Lotto ninth = new Lotto(Arrays.asList(1,2,3,13,5,6));
    public static final Lotto tenth = new Lotto(Arrays.asList(1,2,3,4,5,6));

    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(Arrays.asList(first, second, third, fourth, fifth,
                sixth, seventh, eighth, ninth, tenth));
    }

    @DisplayName("Calculate profit rate of lottos")
    @Test
    void testProfitRate() {
        resetPrize();
        assertThat(lottos.profitRate(winning)).isEqualTo(200_311.5);
    }
}
