package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    @DisplayName("구입 금액에 맞는 개수의 로또를 발급한다")
    void issueLottosByMoney() {
        LottoNumberGenerator generator = new FakeNumberGenerator(List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12)
        ));

        LottoMachine machine = new LottoMachine(generator);
        Lottos lottos = machine.issue(Money.of(2000));

        assertThat(lottos.size()).isEqualTo(2);
    }
}
