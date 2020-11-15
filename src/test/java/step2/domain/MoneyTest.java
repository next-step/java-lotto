package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step2.domain.Money.MONEY_MUST_BE_DIVIDED;
import static step2.domain.Money.MONEY_MUST_NOT_BE_NEGATIVE;

class MoneyTest {
    @DisplayName("생성")
    @Nested
    class Create {
        @DisplayName("실패")
        @Test
        void fail_when_receive_null() {
            // when
            final Throwable thrown = catchThrowable(() -> {
                Money.of(-1);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_NOT_BE_NEGATIVE);
        }

        @DisplayName("성공")
        @Test
        void success() {
            // when
            final Money money = Money.of(1000);

            // then
            assertThat(money).isNotNull();
        }
    }

    @DisplayName("나머지 없이 돈 나누기")
    @Nested
    class DivideWithoutRemainder {
        @DisplayName("나누어 떨어짐")
        @Test
        void success() {
            // given
            final Money money = Money.of(2000);
            final Money lottoPrice = Lotto.getPrice();

            // when
            final int lottoCount = money.divideWithoutRemainder(lottoPrice);

            // then
            assertThat(lottoCount).isEqualTo(2);
        }

        @DisplayName("나누어 떨어지지 않음")
        @Test
        void exist_remainder() {
            // given
            final Money money = Money.of(2001);
            final Money lottoPrice = Lotto.getPrice();

            // when
            final Throwable thrown = catchThrowable(() -> {
                money.divideWithoutRemainder(lottoPrice);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_BE_DIVIDED);
        }
    }

    @DisplayName("돈 나누기")
    @Nested
    class Divide {
        @DisplayName("성공")
        @Test
        void success() {
            // given
            final Money money = Money.of(1000);
            final Money zeroMoney = Money.of(1000);

            // when
            final double result = money.divide(zeroMoney);

            // then
            assertThat(result).isOne();
        }

        @DisplayName("0으로 나누는 경우")
        @Test
        void by_zero() {
            // given
            final Money money = Money.of(1000);
            final Money zeroMoney = Money.of(0);

            // when
            final double result = money.divide(zeroMoney);

            // then
            assertThat(result).isZero();
        }
    }
}