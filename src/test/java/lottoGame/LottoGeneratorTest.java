package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.Lottery;
import lottoGame.model.factory.TestLottoFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void if_input_amount_return_lottery() {
        int amount = 5000;
        InputParameter inputParameter = new InputParameter(amount);
        TestLottoFactory testLottoFactory = new TestLottoFactory();

        LottoGenerator lottoGenerator = new LottoGenerator(inputParameter, testLottoFactory);
        Lottery lottery = lottoGenerator.create();

        assertThat(lottery.getSize()).isEqualTo(5);
    }

}
