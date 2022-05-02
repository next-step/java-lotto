package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "구매 갯수 테스트")
class PurchaseCountTest {

    @Test
    void 구매가격을_입력받아서_로또_구매_갯수를_Wrapping_하는_객체를_생성() {
        PurchaseCount purchaseCount1 = new PurchaseCount(3000);
        PurchaseCount purchaseCount2 = new PurchaseCount(3000);
        assertThat(purchaseCount1).isEqualTo(purchaseCount2);
    }

    @Test
    void 로또_한_개의_가격이_0보다_작으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseCount(1000, -1)
        );
    }


    @Test
    void 구매가격이_0보다_작으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseCount(-1)
        );
    }

    @Test
    void 구매가격으로_한_장도_살_수_없으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseCount(10, 100)
        );
    }

    @Test
    void 구매가격이_나누어떨어지지_않으면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseCount(10, 3)
        );
    }


}