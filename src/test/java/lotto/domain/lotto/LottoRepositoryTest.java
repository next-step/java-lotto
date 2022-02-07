package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.machine.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {
    @Test
    public void 입력한_티켓의개수만큼_로또가_생성된다() {
        //given
        LottoRepository lottoManager = new LottoRepository(new RandomLottoGenerator(), 14);

        //when

        //then
        assertThat(lottoManager.getLottosSize()).isEqualTo(14);
    }
}