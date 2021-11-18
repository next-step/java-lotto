package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [기능분석]
 * 로또는 랜덤번호로 로또를 생성할 수 있다.
 * 로또는 수동번호로 로또를 생성할 수 있다.
 * 로또는 당첨로또와 비교하여 몇개 맞추었는지 계산할 수 있다.
 */
public class LottoTest {

    @Test
    @DisplayName("로또는 랜덤번호로 자신을 생성할 수 있다.")
    void 로또생성_랜덤번호() {
        new Lotto();
    }

    @Test
    @DisplayName("로또는 수동번호로 자신을 생성할 수 있다.")
    void 로또생성_수동번호() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(6, 5, 4, 3, 2, 1));

        lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto).isEqualTo(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
        assertThat(lotto).isEqualTo(new Lotto(new ArrayList<>(Arrays.asList(6,5,4,3,2,1))));
    }

    @ParameterizedTest
    @MethodSource("resultMethodSource")
    @DisplayName("당첨로또와 비교하여 몇개 맞추었는지 계산할 수 있다.")
    void resultMethod(List<Integer> input, int result) {
        Lotto target = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(new Lotto(input).result(target)).isEqualTo(result);
    }

    static Stream<Arguments> resultMethodSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(Arrays.asList(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(Arrays.asList(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(Arrays.asList(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(Arrays.asList(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
