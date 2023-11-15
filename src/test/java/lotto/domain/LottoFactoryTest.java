package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    @DisplayName("성공 - 생성할 로또 개수 만큼 로또가 생성된다.")
    void success_generate_lottos() {
        int lottoCount = 14;
        assertThat(LottoFactory.generateLottos(lottoCount).getLottos()).hasSize(14);
    }
}
