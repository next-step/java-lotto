package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.machine.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    @Test
    public void 입력한_티켓의개수만큼_로또가_생성된다() {
        //given
        LottoManager lottoManager = new LottoManager(new RandomLottoGenerator(), 14);

        //when

        //then
        assertThat(lottoManager.getLottosSize()).isEqualTo(14);
    }
}