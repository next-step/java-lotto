package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void init() {
        lottoFactory = new LottoFactory();
    }

    @Test
    @DisplayName("주어진 금액으로 구매 할 수 있는 만큼 로또를 구입한다.")
    void buyLottoTest() {
        assertAll(
                () -> assertThat(lottoFactory.buyLottos(-1).size()).isEqualTo(0),
                () -> assertThat(lottoFactory.buyLottos(0).size()).isEqualTo(0),
                () -> assertThat(lottoFactory.buyLottos(999).size()).isEqualTo(0),
                () -> assertThat(lottoFactory.buyLottos(1000).size()).isEqualTo(1),
                () -> assertThat(lottoFactory.buyLottos(10_000).size()).isEqualTo(10),
                () -> assertThat(lottoFactory.buyLottos(10_100).size()).isEqualTo(10)
        );
    }
}
