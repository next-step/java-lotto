package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosFactoryTest {
    @Test
    void 로또_여러_개를_자동으로_생성할_수_있다() {
        assertThat(LottosFactory.createAuto(3).getLottoQuantity()).isEqualTo(3);
    }
}
