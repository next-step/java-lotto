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

    @Test
    @DisplayName("수동 로또를 포함하여 전체 로또를 발급한다")
    void issueWithManualAndAuto() {
        LottoNumberGenerator generator = new FakeNumberGenerator(List.of(
            List.of(7, 8, 9, 10, 11, 12),
            List.of(13, 14, 15, 16, 17, 18)
        ));

        LottoMachine machine = new LottoMachine(generator);

        Lotto manual = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos issued = machine.issue(Money.of(3000), 1, List.of(manual));

        assertThat(issued.size()).isEqualTo(3);
        assertThat(issued.values().get(0).numbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(issued.values().get(1).numbers()).containsExactly(7, 8, 9, 10, 11, 12);
        assertThat(issued.values().get(2).numbers()).containsExactly(13, 14, 15, 16, 17, 18);
    }

    @Test
    @DisplayName("수동 구매 수는 전체 구매 수를 초과할 수 없다")
    void manualCountMustNotExceedTotalCount() {
        LottoMachine machine = new LottoMachine(new FakeNumberGenerator(List.of()));

        assertThatThrownBy(() -> machine.issue(Money.of(1000), 2, List.of()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
