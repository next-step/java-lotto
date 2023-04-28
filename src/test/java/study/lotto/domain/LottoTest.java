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

    public static final List<Integer> resultNumbers = List.of(1, 2, 3, 4, 5, 6);

    public static Stream<Arguments> generateLottoAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 11, "SIX"), // 6개 일치 --> 1등
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 7, "BONUS"), // 5개 일치 && 보너스 일치 --> 2등
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 11, "FIVE"), // 5개 일치 && 보너스 불일치 --> 3등
                Arguments.of(List.of(1, 2, 3, 4, 10, 11), 11, "FOUR"), // 4개 일치 && 보너스 일치 --> 4등 (여기서는 보너스 볼이 의미 없음)
                Arguments.of(List.of(1, 2, 3, 4, 10, 11), 45, "FOUR"), // 4개 일치 && 보너스 불일치 --> 4등
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), 11, "THREE"), // 5등
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), 45, "THREE"),
                Arguments.of(List.of(1, 2, 10, 11, 12, 13), 11, "TWO"), // 6등 (상금 X)
                Arguments.of(List.of(1, 2, 10, 11, 12, 13), 45, "TWO"),
                Arguments.of(List.of(1, 10, 11, 12, 13, 14), 11, "ONE"),
                Arguments.of(List.of(1, 10, 11, 12, 13, 14), 45, "ONE"),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 11, "ZERO"),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 45, "ZERO")
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoAndResult")
    void 로또_결과랑_비교(List<Integer> numbers, Integer bonusNumber, ScoreType scoreType) {
        Lotto lotto = new Lotto(numbers);
        ScoreType actual = lotto.getScoreType(new Lotto(resultNumbers), new Bonus(bonusNumber));
        assertThat(actual).isEqualTo(scoreType);
    }

    @DisplayName("숫자_지정하여_로또_구매")
    @ParameterizedTest
    @MethodSource("generateLottoAndResult")
    void 로도_수동구매(List<Integer> numbers) {
        Lotto lotto = Lotto.generate(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
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