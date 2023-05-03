package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    @Test
    @DisplayName("구입금액으로 로또 장수 파악")
    void numberOfLotto() {
        int cost = 14000;
        int expected = 14;

        LottoMachine machine = new LottoMachine(cost);
        machine.create(new LottoCreatingRandomStrategy());

        assertThat(machine.getNumberOfLotto()).isEqualTo(expected);
    }

    @Test
    @DisplayName("구입금액이 음수인지 체크")
    void validate() {
        assertThatThrownBy(() -> {
            new LottoMachine(-14000);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액이 로또 한장 가격보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("구입금액으로 로또 생성 파악")
    void create() {
        int cost = 2000;

        LottoMachine machine = new LottoMachine(cost);

        assertThat(machine.create(new LottoCreatingRandomStrategy(){
            @Override
            public Lotto create() {
                return new Lotto("1, 2, 3, 4, 5, 6");
            }
        })).isEqualTo(new Lottos(Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 6"))));
    }

}
