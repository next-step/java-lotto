package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        Lottos lotto = lottoMachine.createLotto(money);

        assertThat(lotto.lottoCount()).isEqualTo(13);
    }

    @DisplayName("받은 돈에 따라 만들 로또 갯수를 생성")
    @Test
    void getLottoCount() {
        int money = 12400;

        int lottoCount = lottoMachine.getLottoCount(money);

        assertThat(lottoCount).isEqualTo(12);
    }

}