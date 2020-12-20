package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setup(){
        lottoMachine = new LottoMachine();
    }

    @Test
    void exchangeNumberOfLotto(){
        String money = "14000";
        int numberOfLotto = lottoMachine.buyLotto(money);
        assertThat(numberOfLotto).isEqualTo(14);
    }

    @Test
    void createLottos(){
        int createdNumberOfLotto= lottoMachine.createLottos(14);
        assertThat(createdNumberOfLotto).isEqualTo(14);
    }

    @Test
    void getLottoBucket(){
        int lottos = lottoMachine.createLottos(4);
        LottoBucket lottoBuckets = lottoMachine.getLottoBuckets();
        List<Lotto> createdLottos = lottoBuckets.getLottos();
        assertThat(createdLottos.size()).isEqualTo(lottos);
    }


}