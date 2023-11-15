package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {

    private static final int PAID_MONEY = 20_000;

    @Test
    @DisplayName("로또머신은 구매한 로또 리스트를 반환한다.")
    void playReturn() {
        assertThat(new LottoMachine().play(PAID_MONEY))
                .isInstanceOf(Lottos.class);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    @DisplayName("로또 구매금액은 PRICE_PER_LOTTO 보다 커야한다.")
    void paidMoneyAmountCheck(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine().play(input));
    }

    @Test
    @DisplayName("로또 구매금액은 PRICE_PER_LOTTO 로 나누어 떨어져야한다.")
    void paidMoneyUnitCheck() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine().play(1_001));
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void purchase(){
        assertThat(new LottoMachine().play(PAID_MONEY).lottos().size())
                .isEqualTo(PAID_MONEY / LottoMachine.PRICE_PER_LOTTO);
    }
}
