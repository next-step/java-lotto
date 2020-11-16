package lotto;

import lotto.domain.Amount;
import lotto.domain.ManualLottoNumbers;
import lotto.helper.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoFactoryTest {
    @Test
    @DisplayName("주어진 금액으로 구매 할 수 있는 만큼 로또를 구입한다.")
    void buyLottoTest() {
        ManualLottoNumbers manualLottoNumbers = ManualLottoNumbers.empty();
        assertAll(
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, Amount.valueOf(999)).size()).isEqualTo(0),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, Amount.valueOf(1_000)).size()).isEqualTo(1),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, Amount.valueOf(10_000)).size()).isEqualTo(10),
                () -> assertThat(LottoFactory.buyLottos(manualLottoNumbers, Amount.valueOf(10_100)).size()).isEqualTo(10)
        );
    }
}
