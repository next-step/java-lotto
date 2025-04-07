package lotto.domain.service;

import lotto.domain.generator.StaticLottoNumberGenerator;
import lotto.domain.model.LottoWallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("구입 금액에 따라 로또를 구매한다.")
    @Test
    void buyTest() {
        LottoMachine lottoMachine = new LottoMachine(new StaticLottoNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));

        LottoWallet lottoWallet = lottoMachine.buyLottos(2000);
        assertThat(lottoWallet.getCount()).isEqualTo(2);
        assertThat(lottoWallet.getLottos().get(0).getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }
}
