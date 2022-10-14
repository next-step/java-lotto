package lottoGame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParameterTest {
    @Test
    void input_amount_return_lotteryNumber() {
        int amount = 14000;
        InputParameter inputParameter = new InputParameter(amount);
        assertThat(inputParameter.getLotteryNum()).isEqualTo(14);
    }
}
