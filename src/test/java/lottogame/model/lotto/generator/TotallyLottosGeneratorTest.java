package lottogame.model.lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lottogame.model.lotto.Lottos;
import lottogame.model.price.LottoPurchasePrice;
import org.junit.jupiter.api.Test;

class TotallyLottosGeneratorTest {

    @Test
    void 사용자_입력값으로_자동과_수동_로또를_한번에_생성할_수_있다() {
        Lottos lottos = new TotallyLottosGenerator(
                new LottoPurchasePrice(10000),
                List.of("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7")
        ).generateLottos();

        assertThat(lottos.size()).isEqualTo(10);
    }
}