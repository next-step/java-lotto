package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 로또_자동_생성_기능_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        BuyLottos buyLottos = lottoMachine.createAutoLottos(LottoPayment.create(1000));
        assertThat(buyLottos.lottos().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3500:3", "3800:3", "4000:4"}, delimiter = ':')
    void 입력_로또_금액_만큼_로또_자동_생성_테스트(int value, int excepted) {
        LottoMachine lottoMachine = new LottoMachine();
        BuyLottos buyLottos = lottoMachine.createAutoLottos(LottoPayment.create(value));
        assertThat(buyLottos.lottos().size()).isEqualTo(excepted);
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
