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
    void 구매_갯수를_받아서_Wrapping_하는_객체를_생성() {
        assertThat(new PurchaseCount(10)).isEqualTo(new PurchaseCount(10));
    }

    @Test
    void 입력_값이_음수이면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new PurchaseCount(-1)
        );
    }
}