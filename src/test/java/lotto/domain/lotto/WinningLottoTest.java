package lotto.domain.lotto;

import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.lotto.WinningLotto.WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class WinningLottoTest {
    @DisplayName("생성")
    @Test
    void of() {
        // given
        final LottoTicket lottoTicket = LottoTicketMockFactory.createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusNumber = LottoNumber.of(7);

        // when
        final WinningLotto result = WinningLotto.of(lottoTicket, bonusNumber);

        // then
        assertThat(result).isNotNull();
    }

    @DisplayName("당첨 로또 번호와 보너스 번호 중복 시 예외 반환")
    @Test
    void of_throw_exception_when_lotto_no_and_bonus_no_duplicated() {
        // given
        final LottoTicket lottoTicket = LottoTicketMockFactory.createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusNumber = LottoNumber.of(6);

        // when
        final Throwable thrown = catchThrowable(() -> {
            WinningLotto.of(lottoTicket, bonusNumber);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED);
    }
}