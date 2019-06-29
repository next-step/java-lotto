package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoPickLottosFactoryTest {
    @Test
    @DisplayName("자동 선택 로또")
    void create_auto_pick() {
        AutoPickLottosFactory factory = new AutoPickLottosFactory();
        assertThat(factory.apply(new LottoQuantity(3L)).size()).isEqualTo(3);
    }
}
