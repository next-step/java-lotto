package lotto.model;

import lotto.fixture.LottoFixture;
import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static lotto.model.Lotto.LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED;
import static lotto.model.Lotto.LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또를_저장한다() {
        assertThatNoException().isThrownBy(() -> {
            Lotto lotto = Lotto.of(() -> List.of(
                    new LottoNumber(6), new LottoNumber(9),
                    new LottoNumber(17), new LottoNumber(28),
                    new LottoNumber(39), new LottoNumber(45))
            );
        });
    }

    @Test
    void 로또는_로또번호순서와_상관없이_정렬된_값과_같다() {
        List<LottoNumber> actual = Lotto.of(() -> List.of(
                        new LottoNumber(39), new LottoNumber(17),
                        new LottoNumber(6), new LottoNumber(9),
                        new LottoNumber(28), new LottoNumber(45)))
                .numbers();
        List<LottoNumber> expected = List.of(
                new LottoNumber(6), new LottoNumber(9),
                new LottoNumber(17), new LottoNumber(28),
                new LottoNumber(39), new LottoNumber(45));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또번호는_중복되면_오류() {
        assertThatThrownBy(() -> {
            Lotto duplicatedLotto = Lotto.of(() -> List.of(new LottoNumber(6), new LottoNumber(6), new LottoNumber(9), new LottoNumber(17), new LottoNumber(28), new LottoNumber(39)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
    }

    @Test
    void 로또번호목록은_반드시_6개가_저장되어야_한다() {
        assertThatThrownBy(() -> {
            Lotto lottoNumbersSizeIsNotSix = Lotto.of(() -> List.of(new LottoNumber(6), new LottoNumber(17), new LottoNumber(28), new LottoNumber(39)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
    }

    @Test
    void 로또_등수_없음() {
        Lotto buy = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto winning = Lotto.of(() -> List.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)));
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.NONE;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또4등() {
        Lotto buy = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto winning = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FOURTH;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또3등() {
        Lotto buy = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto winning = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(8), new LottoNumber(9)));
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.THIRD;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또2등() {
        Lotto buy = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto winning = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(9)));
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.SECOND;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또1등() {
        Lotto buy = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto winning = Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIRST;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}