package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 로또_자동_생성_기능_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> buyLottos = lottoMachine.createAutoLottos(PurchaseQuantity.create(10));
        assertThat(buyLottos.size()).isEqualTo(10);
    }

    @Test
    void 로또_수동_생성_기능_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        LottoMachine lottoMachine = new LottoMachine();
        Lotto manualLotto = lottoMachine.createManualLotto(lottoNumbers);
        assertThat(manualLotto).isEqualTo(Lotto.create(lottoNumbers));
    }
}
