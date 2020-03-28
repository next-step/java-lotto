package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoMachine;
import step2.domain.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    @DisplayName("입력받은 금액으로 구매 가능한만큼의 로또 객체를 생성한다.")
    void createLotto() {
        Money money = new Money(3000);

        assertThat(LottoMachine.createLottos(money)).isNotNull();   //TODO: 더 좋은 검증 방법이 없을까?
    }
}
