package lotto.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final LottoService lottoService = new LottoService(new PickNumberService());

    @Test
    @DisplayName("입력한 개수만큼 로또를 발급한다.")
    void issueLotto1() {
        int count = 5;

        assertThat(lottoService.issueLotto(count).size()).isEqualTo(count);
    }

}
