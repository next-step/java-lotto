package lotto.service;

import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    @Test
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("금액에 맞는 로또 수량을 구매한다.")
    @Test
    void buy() {
        Lottos lottos = lottoService.buy(14000);

        assertThat(lottos.quantity()).isEqualTo(14);
    }

}