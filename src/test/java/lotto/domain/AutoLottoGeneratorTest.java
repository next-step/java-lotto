package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoGeneratorTest {

    @DisplayName("입력 된 수만큼 자동으로 Lotto가 생성된다.")
    @Test
    void getGeneratorLottosTest() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(10);

        List<Lotto> lottos = autoLottoGenerator.generator();

        assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("0개를 입력하면 빈 List<Lotto>가 생성된다.")
    @Test
    void getGeneratorLottosEmptyTest() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(0);

        List<Lotto> lottos = autoLottoGenerator.generator();

        assertThat(lottos.size()).isEqualTo(0);
    }
}