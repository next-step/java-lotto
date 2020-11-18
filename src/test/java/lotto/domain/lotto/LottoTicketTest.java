package lotto.domain.lotto;

import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.lotto.LottoTicket.*;
import static lotto.domain.lotto.LottoTicketMockFactory.*;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTicketTest {
    private final List<LottoNumber> lottoNumberOneToSix = createLottoNumberListOneToSix();

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
                LottoTicket.of(duplicatedNumber);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        }

        @DisplayName("로또 번호 리스트를 직접 전달")
        @Nested
        class WithLottoTicketNumberList {
            @DisplayName("정상 생성")
            @Test
            void success() {
                // when 
                final LottoTicket lottoTicket = LottoTicket.of();

                // then
                AssertionsForClassTypes.assertThat(lottoTicket).isNotNull();
            }

            @DisplayName("null 로또 리스트가 전달된 경우")
            @Test
            void throw_exception_when_receive_null() {
                // given
                final List<LottoNumber> nullLottoNumbers = null;

                // when 
                final Throwable thrown = catchThrowable(() -> {
                    LottoTicket.of(nullLottoNumbers);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_NULL);
            }

            @DisplayName("로또 번호가 정해진 개수 보다 많은 경우")
            @Test
            void throw_exception_when_receive_lotto_number_size_that_bigger_then_standard() {
                // given
                final List<LottoNumber> lottoNumberOneToSeven = Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6),
                        LottoNumber.of(7)
                );

                // when 
                final Throwable thrown = catchThrowable(() -> {
                    LottoTicket.of(lottoNumberOneToSeven);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_SIZE_NOT_VALID);
            }

            @DisplayName("로또 번호가 정해진 개수 보다 많은 경우")
            @Test
            void throw_exception_when_receive_lotto_number_size_that_less_then_standard() {
                // given
                final List<LottoNumber> lottoNumberOneToFive = Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5)
                );

                // when 
                final Throwable thrown = catchThrowable(() -> {
                    LottoTicket.of(lottoNumberOneToFive);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_SIZE_NOT_VALID);
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
                    LottoTicket.of(duplicatedNumber);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
            }
        }

        @DisplayName("문자열로 생성")
        @Nested
        class with_string {
            @DisplayName("성공")
            @Test
            void success() {
                // given
                final String lottoNumberExpression = "1, 2, 3, 4, 5, 6";

                // when
                final LottoTicket lottoTicket = LottoTicket.of(lottoNumberExpression);

                // then
                assertThat(lottoTicket).isNotNull();
            }

            @DisplayName("로또 번호로 빈 문자열을 받은 경우")
            @ParameterizedTest
            @ValueSource(strings = {"", " ", "         "})
            void lotto_number_is_empty(final String blankExpression) {
                // when
                final Throwable thrown = catchThrowable(() -> {
                    LottoTicket.of(blankExpression);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_BLANK);
            }

            @DisplayName("로또 번호로 null 문자열을 받은 경우")
            @Test
            void lotto_number_is_empty() {
                // given
                final String nullExpression = null;

                // when
                final Throwable thrown = catchThrowable(() -> {
                    LottoTicket.of(nullExpression);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_MUST_NOT_BE_BLANK);
            }
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