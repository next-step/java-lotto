package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void create() {
        //given
        SelectRule selectRule = new RandomSelectRule();

        //when
        LottoMachine result = new LottoMachine(selectRule);

        //then
        assertThat(result).isEqualTo(new LottoMachine(selectRule));
    }

    @Test
    void issue() {
        //given
        Cash cash = new Cash(3000);
        LottoMachine lottoMachine = new LottoMachine(TestObjectSupport.createSelectRule());
        Lottos expectedLottos = TestObjectSupport.createLottos();

        //when
        Lottos result = lottoMachine.issue(cash);

        //then
        assertThat(result).isEqualTo(expectedLottos);
    }
}
