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
        class 양수값이_주어지면 {

            @Test
            void 에러가_발생하지_않는다() {
                assertThatCode(() -> new UserAmount(0))
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
}
