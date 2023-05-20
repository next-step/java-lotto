package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.model.request.ReqAutoLotto;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 발급 테스트")
    void issueAutoForMoney() {
        List<LottoNumbers> manualLotto = List.of(LottoNumbers.of("1,2,3,4,5,6"));
        Lotto lotto = LottoMachine.issueLotto(new AutoLottoNumbersGenerator(), new ReqAutoLotto(Money.wons(2000)), manualLotto);
        assertThat(lotto.getLottoNumbersSize()).isEqualTo(3);
    }
}