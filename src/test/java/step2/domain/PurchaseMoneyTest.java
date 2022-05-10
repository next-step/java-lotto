package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "구매 금액 테스트")
class PurchaseMoneyTest {

    @Test
    void 구매금액을_입력받아서_구매금액과_로또_구매_갯수를_Wrapping_하는_객체를_생성() {
        PurchaseMoney purchaseMoney1 = new PurchaseMoney(3000);
        PurchaseMoney purchaseMoney2 = new PurchaseMoney(3000);
        assertThat(purchaseMoney1).isEqualTo(purchaseMoney2);
    }

    @Test
    void 구매가격이_0보다_작으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(-1)
        );
    }

    @Test
    void 구매가격으로_한_장도_살_수_없으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(999)
        );
    }

    @Test
    void 구매가격이_나누어떨어지지_않으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseMoney(1001)
        );
    }


}