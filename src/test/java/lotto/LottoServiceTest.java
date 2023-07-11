package lotto;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("Money 객체 전달받으면 로또를 발급한다.")
    void generateLotto() {
        Money money = new Money(5000);
        Lottos lottos = lottoService.buyLotto(money);
        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }
}
