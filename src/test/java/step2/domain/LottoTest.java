package step2.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.dto.LottoStatisticsResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.domain.Lotto.*;

class LottoTest {
    private final List<LottoNumber> lottoNumberOneToSix = Arrays.asList(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
    );

    @DisplayName("of")
    @Nested
    class Of {
        @DisplayName("로또 번호 생성 전략을 주입")
        @Test
        void with_strategy() {
            // given
            final CreateLottoNumbersStrategy strategy = () -> lottoNumberOneToSix;

            // when 
            final Lotto lotto = Lotto.of(strategy);

            // then
            assertThat(lotto).isNotNull();
        }

        @DisplayName("로또 번호 리스트를 직접 전달")
        @Nested
        class WithLottoNumberList {
            @DisplayName("정상 생성")
            @Test
            void success() {
                // when 
                final Lotto lotto = Lotto.of(lottoNumberOneToSix);

                // then
                assertThat(lotto).isNotNull();
            }

            @DisplayName("null 리스타가 전달된 경우")
            @Test
            void throw_exception_when_receive_null() {
                // given
                final List<LottoNumber> nullList = null;

                // when 
                final Throwable thrown = catchThrowable(() -> {
                    Lotto.of(nullList);
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
                ;

                // when 
                final Throwable thrown = catchThrowable(() -> {
                    Lotto.of(lottoNumberOneToSeven);
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
                    Lotto.of(lottoNumberOneToFive);
                });

                // then
                Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LOTTO_NUMBER_SIZE_NOT_VALID);
            }
        }

        @DisplayName("아무 전달인자가 없는 경우")
        @Test
        void without_strategy() {
            // when 
            final Lotto lotto = Lotto.of();

            // then
            assertThat(lotto).isNotNull();
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
                final Lotto lotto = Lotto.of(lottoNumberExpression);

                // then
                assertThat(lotto).isNotNull();
            }

            @DisplayName("로또 번호로 빈 문자열을 받은 경우")
            @ParameterizedTest
            @ValueSource(strings = {"", " ", "         "})
            void lotto_number_is_empty(final String blankExpression) {
                // when
                final Throwable thrown = catchThrowable(() -> {
                    Lotto.of(blankExpression);
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
                    Lotto.of(nullExpression);
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
        final CreateLottoNumbersStrategy strategy = () -> lottoNumberOneToSix;

        // when 
        final Lotto lotto = Lotto.of(strategy);

        // then
        assertThat(lotto.countHitNumber(Lotto.of(lottoNumberOneToSix))).isEqualTo(6);
    }
}