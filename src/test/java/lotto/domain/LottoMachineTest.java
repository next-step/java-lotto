package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoMachineTest {

    @Test
    @DisplayName("로또의 기본금액이 1,000으로 14,000원을 입력시 14개의 로또가 생성된다.")
    void createLottoMachine() {
        LottoMachine lottoMachine = new LottoMachine(new Money(14_000));
        Lottos lottos = lottoMachine.getLottoTickets();

        assertThat(lottos.getLottos()).hasSize(14);
    }

    @ParameterizedTest(name = "{0}원으로 LottoNumber을 생성시 천단위 미만은 절사하여 생성한다.")
    @ValueSource(longs = {14_001, 14_999})
    void createLottoMachine(long inputMoney) {
        LottoMachine lottoMachine = new LottoMachine(new Money(inputMoney));
        Lottos lottos = lottoMachine.getLottoTickets();

        assertThat(lottos.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("10000원으로 Lotto를 생성할 때 수동이2개라면 자동은 8개가 생성된다.")
    void createLotto_수동_자동() {
        List<String> manualNumbers = List.of("1,2,3,4,5,6", "7,8,9,10,11,12");
        LottoMachine lottoMachine = new LottoMachine(new Money(10_000), manualNumbers);
        Lottos lottoTickets = lottoMachine.getLottoTickets();

        assertThat(lottoTickets.getManualLottos()).hasSize(manualNumbers.size());
        assertThat(lottoTickets.getLottos()).hasSize(10 - manualNumbers.size());
    }
}