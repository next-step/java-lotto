package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.LottoOrder;

public class LottoOrderTest {
    @Test
    @DisplayName("로또 가격별 발행 테스트")
    public void buyLottoTest() {
        LottoOrder lottoOrder = new LottoOrder(14000);
        assertThat(lottoOrder.getQuantity()).isEqualTo(14);
    }
}
