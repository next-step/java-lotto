package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @Test
    void test_duplicate_winning_numbers() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new WinningLotto(LottoTicket.of(1, 1, 2, 3, 4, 5), LottoNumber.of(6))
        );
    }

    @Test
    void test_duplicate_bonus_number() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new WinningLotto(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoNumber.of(6))
        );
    }

    @Test
    void test_match() {
        LottoTicket ticket = LottoTicket.of(1, 2, 3, 4, 5, 7);
        assertThat(new WinningLotto(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoNumber.of(7)).match(ticket))
                .isEqualTo(LottoResult.BONUS);
    }
}
