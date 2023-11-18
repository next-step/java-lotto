package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    private Money money;

    void createTest(int price) {
        money = new Money(price);
    }

    @Test
    void 로또_구매_금액_유효성_검사_성공() {
        // given
        createTest(1000);
        // when
        int amount = money.price();
        // then
        assertThat(amount).isEqualTo(1000);
    }

    @DisplayName("로또 구입 실패 금액 오류")
    @Nested
    class 구입_실패 {

        @DisplayName("1000원 미만일 경우")
        @Test
        void 금액이_작은_경우() {
            // given
            // when
            // then
            assertThatIllegalArgumentException().isThrownBy(() -> {
                createTest(999);
            });
        }

        @DisplayName("1000원 단위가 아닌경우")
        @Test
        void 단위가_1000원_아닌경우() {
            // given
            // when
            // then
            assertThatIllegalArgumentException().isThrownBy(() -> {
                createTest(1001);
            });
        }
    }
}
