package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosFactoryTest {
    @Test
    void 로또_여러_개를_자동으로_생성할_수_있다() {
        assertThat(LottosFactory.createAuto(3).getLottoQuantity()).isEqualTo(3);
    }

    @Test
    void 로또_여러_개를_수동으로_생성할_수_있다() {
        assertThat(LottosFactory.createManualByStringList(List.of("1,2,3,4,5,6", "1,2,3,4,5,7")).getLottoQuantity()).isEqualTo(2);
    }
}
