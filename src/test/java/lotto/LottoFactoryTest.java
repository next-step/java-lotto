package lotto;

import lotto.service.helper.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoFactoryTest {
    @Test
    @DisplayName("주어진 금액으로 구매 할 수 있는 만큼 로또를 구입한다.")
    void buyLottoTest() {
        List<Set<Integer>> manualLottoNumbers = Collections.emptyList();
        assertAll(
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, 0).size()).isEqualTo(0),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, 999).size()).isEqualTo(0),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, 1_000).size()).isEqualTo(1),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, 10_000).size()).isEqualTo(10),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, 10_100).size()).isEqualTo(10)
        );
    }
}
