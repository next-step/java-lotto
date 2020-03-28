package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    @DisplayName("입력받은 금액으로 구매 가능한만큼의 로또 객체를 생성한다.")
    void createLotto() {
        int money = 3000;
        List<Lotto> lottos = new ArrayList<Lotto>();
        assertThat(LottoMachine.createLottos(money)).isNotNull();
    }
}
