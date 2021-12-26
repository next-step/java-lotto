package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void buyLottos_with_money() {
        // given
        long inputMoney = 6000;
        List<Number> lottoNumbers = new ArrayList<Number>(){{
            add(Number.ONE);
            add(Number.TWO);
            add(Number.THREE);
            add(Number.FOUR);
            add(Number.FIVE);
            add(Number.SIX);
        }};

        Lottos expectedLottos = new Lottos(new ArrayList<Lotto>(){{
            add(new Lotto(lottoNumbers));
            add(new Lotto(lottoNumbers));
            add(new Lotto(lottoNumbers));
            add(new Lotto(lottoNumbers));
            add(new Lotto(lottoNumbers));
            add(new Lotto(lottoNumbers));
        }});

        // when
        Lottos lottos = lottoMachine.buyLottos(inputMoney, () -> lottoNumbers);

        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos).isEqualTo(expectedLottos);
    }

}
