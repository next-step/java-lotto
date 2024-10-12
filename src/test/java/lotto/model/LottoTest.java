package lotto.model;

import lotto.model.enums.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.model.Lotto.*;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또를_저장한다() {
        assertThatNoException().isThrownBy(() -> {
            Lotto lotto = Lotto.of(() -> new Integer[]{6, 9, 17, 28, 39, 45});
        });
    }

    @Test
    void 로또는_로또번호순서와_상관없이_정렬된_값과_같다() {
        List<Integer> actual = Lotto.of(() -> new Integer[]{39, 17, 6, 9, 28, 45}).numbers();
        List<Integer> expected = List.of(6, 9, 17, 28, 39, 45);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또번호는_중복되면_오류() {
        assertThatThrownBy(() -> {
            Lotto duplicatedLotto = Lotto.of(() -> new Integer[]{6, 6, 9, 17, 28, 39});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
    }

    @ParameterizedTest(name = "로또번호는_1_45_사이의_정수가_아니면_오류({0})")
    @MethodSource(value = "falseLottoFixture")
    void 로또번호는_1_45_사이의_정수가_아니면_오류(List<Integer> integers) {
        assertThatThrownBy(() -> {
            Integer[] lottoNumbers = integers.toArray(Integer[]::new);
            Lotto falseLotto = Lotto.of(() -> lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ALLOWED_BETWEEN_6_TO_45_INTEGER);
    }

    @Test
    void 로또번호목록은_반드시_6개가_저장되어야_한다() {
        assertThatThrownBy(() -> {
            Lotto lottoNumbersSizeIsNotSix = Lotto.of(() -> new Integer[]{6, 17, 28, 39});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
    }

    @Test
    void 로또_등수_없음() {
        Lotto buy = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto winning = Lotto.of(() -> new Integer[]{7, 8, 9, 10, 11, 12});
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.NONE;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또4등() {
        Lotto buy = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto winning = Lotto.of(() -> new Integer[]{1, 2, 3, 7, 8, 9});
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FOURTH;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또3등() {
        Lotto buy = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto winning = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 8, 9});
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.THIRD;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또2등() {
        Lotto buy = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto winning = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 9});
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.SECOND;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또1등() {
        Lotto buy = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto winning = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIRST;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> falseLottoFixture() {
        return Stream.of(
                Arguments.of(List.of(0, 6, 17, 28, 39, 45)),
                Arguments.of(List.of(6, 17, 28, 39, 45, 46))
        );
    }
}