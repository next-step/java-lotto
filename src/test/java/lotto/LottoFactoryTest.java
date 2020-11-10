package lotto;

import lotto.service.helper.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoFactoryTest {
    @Test
    @DisplayName("주어진 금액으로 구매 할 수 있는 만큼 로또를 구입한다.")
    void buyLottoTest() {
        assertAll(
                () -> assertThat(LottoFactory.buyLottos(-1).size()).isEqualTo(0),
                () -> assertThat(LottoFactory.buyLottos(0).size()).isEqualTo(0),
                () -> assertThat(LottoFactory.buyLottos(999).size()).isEqualTo(0),
                () -> assertThat(LottoFactory.buyLottos(1_000).size()).isEqualTo(1),
                () -> assertThat(LottoFactory.buyLottos(10_000).size()).isEqualTo(10),
                () -> assertThat(LottoFactory.buyLottos(10_100).size()).isEqualTo(10)
        );
    }
}
