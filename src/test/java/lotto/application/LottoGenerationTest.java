package lotto.application;

import lotto.application.LottoGeneration;
import lotto.domain.Lottos;
import lotto.domain.NumberGeneration;
import lotto.domain.RandomNumberGeneration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGenerationTest {
    @Test
    @DisplayName("로또 1개의 금액을 기준으로 구매 금액에 따라 생성된 로또 갯수 확인")
    void 로또_번호_생성갯수_확인() {
        NumberGeneration randomNumberGeneration = new RandomNumberGeneration();
        LottoGeneration lottoGeneration = new LottoGeneration();

        Lottos lottos = lottoGeneration.generateLottoNumbers(14, randomNumberGeneration);

        Assertions.assertThat(lottos.size()).isEqualTo(14);
    }
}
