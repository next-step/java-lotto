package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumbersTest {

    @Test
    void 랜덤으로_로또번호를_생성한다() {
        assertThatNoException().isThrownBy(LottoNumbers::new);
    }

    @Test
    void 한_게임에_로또번호는_6개다() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        assertThatNoException().isThrownBy(() -> new LottoNumbers(list));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 7, 10})
    void 한_게임에_로또번호는_6개다(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(i);
        }

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(list))
                .withMessage("6개의 로또번호가 필요합니다.");
    }

    @Test
    void 한_게임에_중복된_로또번호가_있으면_안된다() {
        List<Integer> list = List.of(1, 1, 2, 3, 4, 5);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(list))
                .withMessage("중복된 로또번호를 사용할 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("compareIdenticalNumber")
    void 같은_번호의_갯수를_반환한다(List<Integer> numbers1, List<Integer> numbers2, int expected) {
        LottoNumbers lottoNumbers1 = new LottoNumbers(numbers1);
        LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);

        assertThat(lottoNumbers1.countIdenticalLottoNumber(lottoNumbers2)).isEqualTo(expected);
    }

    private static Stream<Arguments> compareIdenticalNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 7, 8, 9), 3),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 7, 8, 9, 10), 2),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 7, 8, 9, 10, 11), 1),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12), 0)
        );
    }

    @Test
    @DisplayName("toString() 은[번호, 번호] 형식의 문자열을 반환한다.")
    void toString은_게임_내_숫자를_반환한다() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers game = new LottoNumbers(list);

        assertThat(game).hasToString("[1, 2, 3, 4, 5, 6]");
    }
}
