package app.action;

import app.domain.lotto.Lotto;
import app.strategy.LottoNumStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    // 로또 생성기.
    @DisplayName("로또 만드는 머신 생성")
    @Test
    void createTest(){
        LottoMachine machine = LottoMachine.create();
        assertThat(machine).isNotEqualTo(null);
    }

    @DisplayName("로또 머신에 전략 주입하기 ( 숫자 만드는 규칙 )")
    @Test
    void insertStrategyTest(){
        LottoNumStrategy strategy = new LottoNumStrategy() {
            @Override
            public Lotto makeLotto() {
                return Lotto.from(Arrays.asList(1,2,3,4,5,6));
            }
        };

        LottoMachine machine = LottoMachine.of(strategy);
        assertThat(machine.makeLotto()).isEqualTo(Lotto.from(Arrays.asList(1,2,3,4,5,6)));
    }
}