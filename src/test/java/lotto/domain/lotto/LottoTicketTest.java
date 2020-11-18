package lotto.domain.lotto;

import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED;
import static lotto.domain.lotto.LottoTicketMockFactory.*;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTicketTest {
    private final LottoNumbers lottoNumberOneToSix = createLottoNumberOneToSix();

    @DisplayName("of")
    @Nested
    class Of {
        @DisplayName("로또 번호 생성 전략을 주입")
        @Test
        void with_strategy() {
            // given
            final LottoNumbersCreateStrategy lottoNumbersStrategy = () -> lottoNumberOneToSix;

            // when 
            final LottoTicket lottoTicket = LottoTicket.of(lottoNumbersStrategy);

            // then
            assertThat(lottoTicket).isNotNull();
        }

        @DisplayName("아무 전달인자가 없는 경우")
        @Test
        void without_strategy() {
            // when 
            final LottoTicket lottoTicket = LottoTicket.of();

            // then
            assertThat(lottoTicket).isNotNull();
        }

        @DisplayName("로또 번호가 정해진 개수 보다 많은 경우")
        @Test
        void throw_exception_when_receive_lotto_number_duplicated() {
            // given
            final List<LottoNumber> duplicatedNumber = Arrays.asList(
                    LottoNumber.of(1),
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5)
            );

            // when 
            final Throwable thrown = catchThrowable(() -> {
                LottoTicket.of(LottoNumbers.of(duplicatedNumber));
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        }
    }

    @Test
    void countHitNumber() {
        // given
        final LottoNumbersCreateStrategy lottoNumbersStrategy = () -> lottoNumberOneToSix;

        // when 
        final LottoTicket lottoTicket = LottoTicket.of(lottoNumbersStrategy);

        // then
        assertThat(lottoTicket.countHitNumber(LottoTicket.of(lottoNumberOneToSix))).isEqualTo(6);
    }

    @Test
    void hasNotDuplicates_when_receive_not_duplicated_lotto_number() {
        // when
        final boolean result = LottoTicket.hasNotDuplicates(lottoNumberOneToSix);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void hasDuplicates_when_receive_not_duplicated_lotto_number() {
        // when
        final boolean result = LottoTicket.hasDuplicates(lottoNumberOneToSix);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isMatchBonus_matched() {
        // given
        final LottoTicket lottoTicket = LottoTicket.of(() -> lottoNumberOneToSix);
        final LottoNumber bonusNumber = LottoNumber.of(6);

        // when
        final boolean result = lottoTicket.isMatchBonus(bonusNumber);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isMatchBonus_not_matched() {
        // given
        final LottoTicket lottoTicket = LottoTicket.of(() -> lottoNumberOneToSix);
        final LottoNumber bonusNumber = LottoNumber.of(7);

        // when
        final boolean result = lottoTicket.isMatchBonus(bonusNumber);

        // then
        assertThat(result).isFalse();
    }
}