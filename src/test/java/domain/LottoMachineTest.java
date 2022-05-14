package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        int cash = 3000;
        LottoMachine lottoMachine = new LottoMachine(TestObjectSupport.createSelectRule());
        Lotto lotto = TestObjectSupport.createLotto();
        List<Lotto> expectedLottos = Arrays.asList(lotto, lotto, lotto);

        //when
        List<Lotto> result = lottoMachine.issue(cash);

        //then
        assertThat(result).isEqualTo(expectedLottos);
    }
}
