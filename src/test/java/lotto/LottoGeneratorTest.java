package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("단일 로또 생성 기능")
    public void generateLottoTest() {
        Lotto lotto = LottoGenerator.generateAutoLotto();

        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("여러 로또 생성 기능")
    public void generateLottosTest() {
        long size = 4;
        Lottos lottos = LottoGenerator.generateAutoLottos(size);

        assertThat(lottos.getLottoCount()).isEqualTo(size);
    }
}
