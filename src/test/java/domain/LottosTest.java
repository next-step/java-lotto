package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Prize.resetPrize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    public static final Lotto winning = generateLotto(Arrays.asList(1,2,3,4,5,6));
    public static final Lotto first = generateLotto(Arrays.asList(1,11,12,13,14,15));
    public static final Lotto second = generateLotto(Arrays.asList(1,2,12,13,14,15));
    public static final Lotto third = generateLotto(Arrays.asList(1,2,3,13,14,15));
    public static final Lotto fourth = generateLotto(Arrays.asList(1,2,12,4,14,15));
    public static final Lotto fifth = generateLotto(Arrays.asList(1,11,12,4,5,15));
    public static final Lotto sixth = generateLotto(Arrays.asList(1,2,3,4,14,15));
    public static final Lotto seventh = generateLotto(Arrays.asList(1,2,3,13,5,15));
    public static final Lotto eighth = generateLotto(Arrays.asList(1,2,3,4,5,15));
    public static final Lotto ninth = generateLotto(Arrays.asList(1,2,3,13,5,6));
    public static final Lotto tenth = generateLotto(Arrays.asList(1,2,3,4,5,6));

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

    private static Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList()));
    }
}
