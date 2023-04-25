package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCreateServiceTest {
    @Test
    void 자동생성된_로또_갯수_테스트() {
        AutoLottoService autoLotteryService = new AutoLottoService();
        assertThat(autoLotteryService.getLotto().size()).isEqualTo(6);
    }
}
