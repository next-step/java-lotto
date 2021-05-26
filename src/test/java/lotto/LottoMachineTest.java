package lotto;

import lotto.model.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setup() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("금액은 1000원 단위")
    public void validateLottoMoney(){
        assertThat(lottoMachine.validateMoney(15000)).isEqualTo(true);
    }

    @Test
    @DisplayName("입력 받은 금액 / 1000 만큼 구매")
    public void buyLottoCount(){
        assertThat(lottoMachine.buyCount(15000)).isEqualTo(15);
    }
}
