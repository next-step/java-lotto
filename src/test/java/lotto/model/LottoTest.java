package lotto.model;

import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.Lotto.LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED;
import static lotto.model.Lotto.LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6;
import static lotto.model.dto.LottoNumber.of;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또번호목록과_보너스번호를_저장한다() {
        assertThatNoException().isThrownBy(() -> {
            Lotto lotto = Lotto.of(
                    () -> List.of(of(6), of(9), of(17), of(28), of(39), of(45))
            );
        });
    }

    @Test
    void 로또는_로또번호순서와_상관없이_정렬된_값과_같다() {
        List<LottoNumber> actual = Lotto.of(
                        () -> List.of(of(39), of(17), of(6), of(9), of(28), of(45))
                )
                .numbers();
        List<LottoNumber> expected = List.of(of(6), of(9), of(17), of(28), of(39), of(45));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또번호는_중복되면_오류() {
        assertThatThrownBy(() -> {
            Lotto duplicatedLotto = Lotto.of(
                    () -> List.of(of(6), of(6), of(17), of(28), of(39), of(45))
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
    }

    @Test
    void 로또번호목록은_반드시_6개가_저장되어야_한다() {
        assertThatThrownBy(() -> {
            Lotto lottoNumbersSizeIsNotSix = Lotto.of(
                    () -> List.of(of(6), of(17), of(28), of(39))
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
    }

    @Test
    void 로또_등수_없음() {
        Lotto buy = Lotto.of(
                () -> List.of(of(7), of(8), of(9), of(10), of(11), of(12))
        );

        Lotto winningLotto = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(13);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.NONE;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또5등() {
        Lotto buy = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(7), of(8), of(9))
        );
        Lotto winningLotto = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(13);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIFTH;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또4등() {
        Lotto buy = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(8), of(9))
        );
        Lotto winningLotto = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(13);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FOURTH;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또3등() {
        Lotto buy = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(9))
        );
        Lotto winningLotto = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(13);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.THIRD;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또2등() {
        Lotto buy = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(9))
        );
        Lotto winningLotto = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(9);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.SECOND;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또1등() {
        Lotto buy = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        Lotto winningLotto = Lotto.of(
                () -> List.of(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(13);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIRST;

        assertThat(actual).isEqualTo(expected);
    }

}