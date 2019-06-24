package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRetailerTest {

    @Test
    @DisplayName("금액에 대한 개수")
    public void buyLottoTest() {
        List<LottoNumbers> lottos = LottoRetailer.buy(14000);
        assertThat(lottos.size()).isEqualTo(14);
    }
}
