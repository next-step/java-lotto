package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    void lottosCreateTest(){
        Machine numberMachine = new NumberMachine();
        numberMachine.setNumber("");
        int money = 6500;
        Lottos lottos = new Lottos(money, numberMachine);

        assertThat(lottos.lottoList.size()).isEqualTo(money/1000);
    }
}
