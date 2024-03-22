package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private final int LOTTO_SIZE = 6;

    @Test
    void 로또_리스트() {
        assertThat(LottoGenerator.createLottos()).hasSize(LOTTO_SIZE);
    }
}
