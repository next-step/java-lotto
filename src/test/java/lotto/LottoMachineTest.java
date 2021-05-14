package lotto;

import lotto.controller.LottoMachine;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("로또 머신은 구입 가능한 로또의 수 만큼 로또를 발급한다.")
    @Test
    public void makeBunchOfLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> bunchOfLotto = lottoMachine.makeBunchOfLotto(14000);
        Assertions.assertThat(bunchOfLotto.size()).isEqualTo(lottoMachine.countPurchasable(14000));
    }

    @DisplayName("금액 입력시 구입 금액에 해당하는 `로또를 살 수 있다`.")
    @Test
    public void countPurchasableTest() {
        int purchaseAmount = 14000;
        assertThat(purchaseAmount / 1000).isEqualTo(14);
    }

    @Test
    void makeLottoNumbersTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNumbers = lottoMachine.makeLottoNumbers();
        System.out.println("lottoNumbers.size() = " + lottoNumbers.size());
        System.out.println("lottoNumbers.toString() = " + lottoNumbers.toString());
    }
}
