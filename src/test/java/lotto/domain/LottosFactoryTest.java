package lotto.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

public class LottosFactoryTest {
    @Test
    void 로또_여러_개를_자동으로_생성할_수_있다() {
        AssertionsForClassTypes.assertThat(LottosFactory.createAuto(3).getLottoQuantity()).isEqualTo(3);
    }
}
