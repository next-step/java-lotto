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
//        int numberOfLotto = lottoMachine.buyLotto(money);
        LottoBucket lottoBucket = lottoMachine.buyLotto(money);
        assertThat(lottoBucket.getLottos().size()).isEqualTo(14);
    }

    @Test
    void createLottos(){
        LottoBucket lottos = lottoMachine.createLottos(14);
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

    @Test
    void getLottoBucket(){
        LottoBucket lottos = lottoMachine.createLottos(4);
        LottoBucket lottoBuckets = lottoMachine.getLottoBuckets();
        List<Lotto> createdLottos = lottoBuckets.getLottos();
        assertThat(createdLottos.size()).isEqualTo(lottos.getLottos().size());
    }


}