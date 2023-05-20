package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.model.request.ReqAutoLotto;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 발급 테스트")
    void issueAutoForMoney() {
        Lotto lotto = LottoMachine.issueLotto(new AutoLottoNumbersGenerator(), new ReqAutoLotto(Money.wons(2000)));
        assertThat(lotto.getLottoNumbersSize()).isEqualTo(2);
    }
}