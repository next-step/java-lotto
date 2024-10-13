package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트() {
        Lottos lottos = new Lottos();
        lottos.buyLotto(3, () -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }
}
