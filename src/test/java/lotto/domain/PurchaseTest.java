package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    private Purchase purchase;

    void setUp(int amount) {
        purchase = new Purchase(amount);
    }

    @Test
    void 로또_구매_금액_유효성_검사_성공() {
        // given
        setUp(1000);
        // when
        int amount = purchase.amount();
        // then
        assertThat(amount).isEqualTo(1000);
    }

    @Test
    void 로또_구매_갯수() {
        // given
        setUp(1000);
        // when
        int lottoCount = purchase.lottoCount();
        // then
        assertThat(lottoCount).isEqualTo(1);
    }

    @Test
    void 로또_구매_수량_출력문구(){
        // given
        setUp(1000);
        // when
        String result = purchase.toString();
        // then
        assertThat(result).isEqualTo("1개를 구매했습니다.");
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
                setUp(999);
            }).withMessageMatching("로또 구입 금액은 1000원 이상 입력해야 합니다.");
        }

        @DisplayName("1000원 단위가 아닌경우")
        @Test
        void 단위가_1000원_아닌경우() {
            // given
            // when
            // then
            assertThatIllegalArgumentException().isThrownBy(() -> {
                setUp(1001);
            }).withMessageMatching("로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }
}
