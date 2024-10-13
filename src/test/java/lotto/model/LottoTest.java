package lotto.model;

import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.LottoFixture.*;
import static lotto.model.Lotto.LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED;
import static lotto.model.Lotto.LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또를_저장한다() {
        assertThatNoException().isThrownBy(() -> {
            Lotto lotto = Lotto.of(() -> LOTTO_NUMBERS);
        });
    }

    @Test
    void 로또는_로또번호순서와_상관없이_정렬된_값과_같다() {
        List<LottoNumber> actual = Lotto.of(() -> UNORDERED_LOTTO_NUMBERS)
                .numbers();
        List<LottoNumber> expected = LOTTO_NUMBERS;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또번호는_중복되면_오류() {
        assertThatThrownBy(() -> {
            Lotto duplicatedLotto = Lotto.of(() -> DUPLICATED_LOTTO_NUMBERS);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
    }

    @Test
    void 로또번호목록은_반드시_6개가_저장되어야_한다() {
        assertThatThrownBy(() -> {
            Lotto lottoNumbersSizeIsNotSix = Lotto.of(() -> NOT_SIZE_6_LOTTO_NUMBERS);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
    }

    @Test
    void 로또_등수_없음() {
        Lotto buy = Lotto.of(() -> NONE_RANKED_LOTTO_NUMBERS);
        Lotto winning = Lotto.of(() -> WINNING_LOTTO_NUMBERS);
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.NONE;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또4등() {
        Lotto buy = Lotto.of(() -> FOURTH_LOTTO_NUMBERS);
        Lotto winning = Lotto.of(() -> WINNING_LOTTO_NUMBERS);
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FOURTH;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또3등() {
        Lotto buy = Lotto.of(() -> THIRD_LOTTO_NUMBERS);
        Lotto winning = Lotto.of(() -> WINNING_LOTTO_NUMBERS);
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.THIRD;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또2등() {
        Lotto buy = Lotto.of(() -> SECOND_LOTTO_NUMBERS);
        Lotto winning = Lotto.of(() -> WINNING_LOTTO_NUMBERS);
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.SECOND;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또1등() {
        Lotto buy = Lotto.of(() -> FIRST_LOTTO_NUMBERS);
        Lotto winning = Lotto.of(() -> WINNING_LOTTO_NUMBERS);
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIRST;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}