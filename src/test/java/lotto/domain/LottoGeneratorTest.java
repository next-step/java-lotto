package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 로또생성() {
        int amount = 10000;
        assertThat(LottoGenerator.createLottos(amount).getQuantity()).isEqualTo(10);
    }
}
