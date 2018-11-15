package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTypeTest {

    @Test
    public void 로또타입찾기_매개변수3() {
        LottoType lottoType = LottoType.findLottoType(3);

        assertThat(lottoType).isEqualTo(LottoType.THREE);
    }

    @Test
    public void 수량에해당하는_수익계() {
        LottoType lottoType = LottoType.THREE;
        int result = lottoType.computeEarning(10);

        assertThat(result).isEqualTo(50000);
    }
}