package study.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    public static Stream<Arguments> generateLottoAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 5),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), List.of(1, 2, 3, 4, 5, 6), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoAndResult")
    void 로또_결과랑_비교(List<Integer> numbers, List<Integer> resultNumbers, Integer score) {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getScore(new Lotto(resultNumbers))).isEqualTo(score);
    }

    @DisplayName("자동구매하면_6개의_숫자가_중복없이_오름순")
    @Test
    void 로또_자동구매() {
        Lotto lotto = Lotto.autoGenerate();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        for (int i = 1; i < lotto.getNumbers().size(); i++) {
            Integer before = lotto.getNumbers().get(i - 1);
            Integer next = lotto.getNumbers().get(i);
            assertThat(next).isGreaterThan(before);
        }
    }
}