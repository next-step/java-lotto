package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("정상적인 로또 구입 금액 입력시 로또 서비스 생성 정상적으로 처리")
    void create() {
        int money = 14000;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoService(money));
    }
}
