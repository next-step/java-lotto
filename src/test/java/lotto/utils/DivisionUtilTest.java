package lotto.utils;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionUtilTest {

    @Test
    @DisplayName("1000원 단위로 나누기")
    public void divide() throws Exception {
        int quotient = DivisionUtil.divideByThousand(new PurchaseAmount(1001));
        assertThat(quotient).isEqualTo(1);
    }
}
