package step02Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.LottoPrice;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountTest {

    private LottoPrice lottoPrice;

    @BeforeEach
    void setLottoPrice() throws Exception {
        lottoPrice = new LottoPrice(5000);
    }

    @Test
    @DisplayName("입력한 돈에 맞게 로또 개수 출력 테스트")
    void calculationCount() {
        assertThat(LottoPrice.calculationCount(lottoPrice)).isEqualTo(5);
    }
}
