package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoPurchaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"} )
    void 로또는_1000원_단위로_구입할_수_있다(BigDecimal amount) {
        LottoPurchase lottoPurchase = new LottoPurchase(amount);

        assertThat(lottoPurchase.amount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "999"} )
    void 로또_구입을_시도할_때_금액이_1000원_미만이면_예외를_발생시킨다(BigDecimal amount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoPurchase.validate(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "2500", "9999"} )
    void 로또_구입을_시도할_때_금액이_1000원_단위가_아니면_예외를_발생시킨다(BigDecimal amount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoPurchase.validate(amount);
        });
    }

    @Test
    void 로또_구입_금액에_해당하는_로또를_발급한다() {
        LottoPurchase lottoPurchase = new LottoPurchase(BigDecimal.valueOf(14000));

        assertThat(lottoPurchase.size()).isEqualTo(14);
    }

    @Test
    void 수동_구매_수가_총_구매_가능_수를_초과하면_예외를_발생시킨다() {
        LottoPurchase lottoPurchase = new LottoPurchase(BigDecimal.valueOf(14000));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoPurchase.validateManualCount(15);
        });
    }
    
    @Test
    void 수동_구매_수가_음수이면_예외를_발생시킨다() {
        LottoPurchase lottoPurchase = new LottoPurchase(BigDecimal.valueOf(14000));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoPurchase.validateManualCount(-1);
        });
    }

}
