package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoGeneratorTest {

    @DisplayName("입력 된 수만큼 자동으로 Lotto가 생성된다.")
    @Test
    void getGeneratorLottosTest() {
        List<Lotto> lottos = AutoLottoGenerator.generate(10);

        assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("0개를 입력하면 빈 List<Lotto>가 생성된다.")
    @Test
    void getGeneratorLottosEmptyTest() {

        List<Lotto> lottos = AutoLottoGenerator.generate(0);

        assertThat(lottos.size()).isEqualTo(0);
    }
}