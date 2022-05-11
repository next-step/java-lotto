package lotto.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserAmountTest {

    @Nested
    class 생성자는 {

        @Nested
        class 음수값이_주어지면 {

            @Test
            void IllegalArgumentException을_던진다() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new UserAmount(-1));
            }
        }

        @Nested
        class 로또가격보다_작은값이_주어지면 {

            @Test
            void IllegalArgumentException을_던진다() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new UserAmount(999));
            }
        }

        @Nested
        class 로또가격보다_같거나_큰값이_주어지면 {

            @Test
            void 에러가_발생하지_않는다() {
                assertThatCode(() -> new UserAmount(1000))
                        .doesNotThrowAnyException();
            }
        }
    }

    @Nested
    class calculateRevenue_메서드는 {

        @Nested
        class 합계금액이_주어지면 {

            @Test
            void 수익률을_리턴한다() {
                UserAmount userAmount = new UserAmount(10000);

                double actual = userAmount.calculateRevenue(30000000);

                assertThat(actual).isEqualTo(3000.0);
            }
        }
    }

    @Nested
    class getRandomLottoSize_메서드는 {

        @Test
        void 리턴한다() {
            UserAmount userAmount = new UserAmount(10000);

            int actual = userAmount.getRandomLottoSize(3);

            assertThat(actual).isEqualTo(7);
        }
    }

    @Nested
    class canBuy_메서드는 {

        @Nested
        class 충분한_개수가_주어지면 {

            @Test
            void true를_리턴한다() {
                UserAmount userAmount = new UserAmount(10000);

                boolean actual = userAmount.canBuy(10);

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class 초과한_개수가_주어지면 {

            @Test
            void false를_리턴한다() {
                UserAmount userAmount = new UserAmount(10000);

                boolean actual = userAmount.canBuy(11);

                assertThat(actual).isFalse();
            }

        }
    }
}
