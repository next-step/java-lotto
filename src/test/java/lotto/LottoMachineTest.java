package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.application.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
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
    @DisplayName("수동 로또가 있으면 수동 + 자동을 합쳐 전체 구매 개수를 맞춘다")
    void issueMixedLottos() {
        LottoNumberGenerator generator = new FakeNumberGenerator(List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(13, 14, 15, 16, 17, 18)
        ));

        LottoMachine machine = new LottoMachine(generator);

        Money money = Money.of(5000);
        List<Lotto> manual = List.of(
            new Lotto(List.of(21, 22, 23, 24, 25, 26)),
            new Lotto(List.of(31, 32, 33, 34, 35, 36))
        );
        Lottos issued = machine.issue(money, manual);

        assertThat(issued.size()).isEqualTo(5);
        assertThat(issued.values())
            .anySatisfy(l -> assertThat(l.numbers()).containsExactly(21, 22, 23, 24, 25, 26))
            .anySatisfy(l -> assertThat(l.numbers()).containsExactly(31, 32, 33, 34, 35, 36));
    }

    @Test
    @DisplayName("수동 로또 개수가 전체 구매 개수보다 많으면 예외")
    void manualCountCannotExceedTotal() {
        LottoNumberGenerator generator = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoMachine machine = new LottoMachine(generator);

        Money money = Money.of(1000);
        List<Lotto> manual = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        assertThatThrownBy(() -> machine.issue(money, manual))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
