package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("돈을 받으면 금액만큼의 로또를 발급한다")
    @ParameterizedTest
    @ValueSource(ints = {3000, 10000})
    void issue_Then_issuedLottoPriceEqualsToPaidPrice(int paidMoney) {
        Lottos lottos = lottoMachine.issue(paidMoney);
        assertThat(lottos.getPriceTotal()).isEqualTo(paidMoney);
    }

    @DisplayName("거슬러줘야 하는 돈을 받으면 IllegalArgumentException")
    @Test
    void issue_When_paidMoneyToBeReturned_Then_IllegalArgumentException() {
        assertThatThrownBy(() -> lottoMachine.issue(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
