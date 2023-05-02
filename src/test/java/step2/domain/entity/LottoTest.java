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

    public static Lotto createTestLotto(String number) {
        return Lotto.winner(number);
    }
}