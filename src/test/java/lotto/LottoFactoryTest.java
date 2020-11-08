package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void init() {
        lottoFactory = new LottoFactory();
    }

    @Test
    @DisplayName("구입 금액으로 구매 할 수 있는 만큼 로또를 구입한다.")
    void buyLottoTest() {
        List<Lotto> lottos = lottoFactory.buyLotto(10000);
        assertThat(lottos.size()).isEqualTo(10);
    }
}
