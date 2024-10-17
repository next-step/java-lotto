package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAgentTest {
    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 20000})
    @DisplayName("금액에 비례하여 Lotto가 구입됩니다.")
    void buyCardinalityTest(int price) {
        LottoAgent agent = LottoAgent.newInstance();
        agent.deposit(price);
        agent.buyAutomatically(() -> LottoNumbers.valueOf(List.of(1, 3, 5, 7, 9, 11)));
        PurchasedLottos lottos = agent.getPurchasedLottos();
        assertThat(lottos.size()).isEqualTo(price / 1000);
    }
}
