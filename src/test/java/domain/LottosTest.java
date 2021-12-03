package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    public static final Lotto WINNING_LOTTO = generateLotto(Arrays.asList(1,2,3,4,5,6));
    public static final Lotto FIRST_LOTTO = generateLotto(Arrays.asList(1,11,12,13,14,15));
    public static final Lotto SECOND_LOTTO = generateLotto(Arrays.asList(1,2,12,13,14,15));
    public static final Lotto THIRD_LOTTO = generateLotto(Arrays.asList(1,2,3,13,14,15));
    public static final Lotto FOURTH_LOTTO = generateLotto(Arrays.asList(1,2,12,4,14,15));
    public static final Lotto FIFTH_LOTTO = generateLotto(Arrays.asList(1,11,12,4,5,15));
    public static final Lotto SIXTH_LOTTO = generateLotto(Arrays.asList(1,2,3,4,14,15));
    public static final Lotto SEVENTH_LOTTO = generateLotto(Arrays.asList(1,2,3,13,5,15));
    public static final Lotto EIGHTH_LOTTO = generateLotto(Arrays.asList(1,2,3,4,5,15));
    public static final Lotto NINTH_LOTTO = generateLotto(Arrays.asList(1,2,3,13,5,6));
    public static final Lotto TENTH_LOTTO = generateLotto(Arrays.asList(1,2,3,4,5,6));

    public static final Lottos LOTTOS = new Lottos(Arrays.asList(FIRST_LOTTO, SECOND_LOTTO, THIRD_LOTTO, FOURTH_LOTTO, FIFTH_LOTTO,
            SIXTH_LOTTO, SEVENTH_LOTTO, EIGHTH_LOTTO, NINTH_LOTTO, TENTH_LOTTO));


    @DisplayName("Test matchedNumbers function of lottos")
    @Test
    void testMatchedNumbers() {
        List<Integer> matched = LOTTOS.matchedNumbers(WINNING_LOTTO);
        List<Integer> expected = Arrays.asList(1, 2, 3, 3, 3, 4, 4, 5, 5, 6);

        for (int i=0; i < matched.size(); i++) {
            assertThat(matched.get(i)).isEqualTo(expected.get(i));
        }
    }

    private static Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList()));
    }
}
