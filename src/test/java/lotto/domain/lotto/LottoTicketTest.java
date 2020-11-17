package lotto.domain.lotto;

import lotto.domain.lotto.strategy.LottoNumberCreateStrategy;
import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED;
import static lotto.domain.lotto.LottoTicketMockFactory.createLottoNumberOneToSix;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTicketTest {
    private final LottoNumbers lottoNumberOneToSix = createLottoNumberOneToSix();

    private static LottoNumbers duplicatedLottoNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> duplicatedLottoNumberList = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.MAX
        );
        duplicatedLottoNumbers = LottoNumbers.of(duplicatedLottoNumberList);
    }

    @DisplayName("of")
    @Nested
    class Of {
        @DisplayName("로또 번호 생성 전략을 주입")
        @Test
        void with_strategy() {
            // given
            final LottoNumbersCreateStrategy lottoNumbersStrategy = (LottoNumber lottoNumber) -> lottoNumberOneToSix;
            final LottoNumberCreateStrategy bonusNumberStrategy = () -> LottoNumber.MAX;

            // when 
            final LottoTicket lottoTicket = LottoTicket.of(lottoNumbersStrategy, bonusNumberStrategy);

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
                LottoTicket.of(LottoNumbers.of(duplicatedNumber), LottoNumber.MIN);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        }
    }

    @Test
    void countHitNumber() {
        // given
        final LottoNumbersCreateStrategy lottoNumbersStrategy = (LottoNumber lottoNumber) -> lottoNumberOneToSix;
        final LottoNumberCreateStrategy bonusNumberStrategy = () -> LottoNumber.MAX;

        // when 
        final LottoTicket lottoTicket = LottoTicket.of(lottoNumbersStrategy, bonusNumberStrategy);

        // then
        assertThat(lottoTicket.countHitNumber(LottoTicket.of(lottoNumberOneToSix, LottoNumber.MAX))).isEqualTo(6);
    }

    @Test
    void hasNotDuplicates_when_receive_not_duplicated_lotto_number() {
        // when
        final boolean result = LottoTicket.hasNotDuplicates(lottoNumberOneToSix, LottoNumber.MAX);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void hasNotDuplicates_when_receive_duplicated_lotto_number() {
        // when
        final boolean result = LottoTicket.hasNotDuplicates(duplicatedLottoNumbers, LottoNumber.MAX);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void hasDuplicates_when_receive_not_duplicated_lotto_number() {
        // when
        final boolean result = LottoTicket.hasDuplicates(lottoNumberOneToSix, LottoNumber.MAX);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void hasDuplicates_when_receive_duplicated_lotto_number() {
        // when
        final boolean result = LottoTicket.hasDuplicates(duplicatedLottoNumbers, LottoNumber.MAX);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isMatchBonus_matched() {
        // given
        final LottoTicket lottoTicket = LottoTicket.of((LottoNumber lottoNumber) -> lottoNumberOneToSix, () -> LottoNumber.MAX);
        final LottoTicket winningLottery = LottoTicket.of((LottoNumber lottoNumber) -> lottoNumberOneToSix, () -> LottoNumber.MAX);

        // when
        final boolean result = lottoTicket.isMatchBonus(winningLottery);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isMatchBonus_not_matched() {
        // given
        final LottoTicket lottoTicket = LottoTicket.of((LottoNumber lottoNumber) -> lottoNumberOneToSix, () -> LottoNumber.MAX);
        final LottoTicket winningLottery = LottoTicket.of((LottoNumber lottoNumber) -> lottoNumberOneToSix, () -> LottoNumber.of(7));

        // when
        final boolean result = lottoTicket.isMatchBonus(winningLottery);

        // then
        assertThat(result).isFalse();
    }
}