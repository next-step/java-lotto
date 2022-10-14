package lottoGame;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    void if_input_amount_return_lotto() {
        int amount = 5000;
        InputParameter inputParameter = new InputParameter(amount);

        LottoGenerator lottoGenerator = new LottoGenerator(inputParameter);

    }

}
