package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또의 기본금액이 1,000으로 14,000원을 입력시 14개의 로또가 생성된다.")
    void createLottoMachine() {
        LottoMachine lottoMachine = new LottoMachine(new Money(14_000));
        assertThat(lottoMachine.countTotalLotto()).isEqualTo(14);
    }

    @ParameterizedTest(name = "{0}원으로 LottoNumber을 생성시 천단위 미만은 절사하여 생성한다.")
    @ValueSource(longs = {14_001, 14_999})
    void createLottoMachine(long inputMoney) {
        LottoMachine lottoMachine = new LottoMachine(new Money(inputMoney));
        assertThat(lottoMachine.countTotalLotto()).isEqualTo(14);
    }
}