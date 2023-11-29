package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.strategy.LottoNumberManualGenerator;

class LottoNumberManualGeneratorTest {

    @Test
    @DisplayName("사용자가 입력한 로또번호로 로또를 생성한다.")
    void generateManualLottoNumbers() {
        LottoPurchase lottoPurchase = new LottoPurchase(1000, List.of("1, 2, 3, 4, 5, 6"));
        assertThat(new LottoNumberManualGenerator().generateLottos(lottoPurchase)).hasSize(1);
    }


}
