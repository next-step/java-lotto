package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("받은 돈 만큼 로또를 생성한다.")
    @Test
    void lottoCount() {
        int money = 13500;

        List<Lotto> lotto = lottoMachine.createLotto(money);

        assertThat(lotto.size()).isEqualTo(13);
    }


}