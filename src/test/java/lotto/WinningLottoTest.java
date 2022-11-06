package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @Test
    void test_duplicate_winning_numbers() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new WinningLotto(6, 1, 1, 2, 3, 4, 5)
        );
    }

    @Test
    void test_duplicate_bonus_number() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new WinningLotto(6, 1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void test_match() {
        LottoTicket ticket = LottoTicket.of(1, 2, 3, 4, 5, 7);
        assertThat(new WinningLotto(7, 1, 2, 3, 4, 5, 6).match(ticket))
                .isEqualTo(LottoResult.BONUS);
    }
}
