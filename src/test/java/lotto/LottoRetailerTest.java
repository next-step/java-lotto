package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRetailerTest {

    @Test
    @DisplayName("수량에 따른 자동 구매")
    public void buyLottoTest() {
        assertThat(LottoRetailer.buyAutoPick(2).size()).isEqualTo(2);
    }
}
