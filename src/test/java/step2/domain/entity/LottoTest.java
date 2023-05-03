package step2.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void 지난주_당첨_번호를_정상적으로_입력받는다() {
        final var lotto = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 지난주_당첨번호가_6자리가_아닐경우_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Lotto.winner("1, 2, 3, 4, 5")
        );
    }

    @Test
    void 당첨번호와_로또의_일치하는_번호_갯수를_구한다() {
        final var winner = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var compare = new Lotto(1, 2, 3, 4, 7, 8);

        final var actual = winner.countSameNumber(compare);

        assertThat(actual).isEqualTo(4);
    }
}
