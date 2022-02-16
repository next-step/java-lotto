package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoGameManager;
import lotto.domain.machine.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    public void 수동으로_입력한_티켓의개수만큼_로또가_생성된다() {
        //given
        List<List<Integer>> lottoNumbers = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        List<Lotto> lottosByManual = LottoGameManager.getLottosByManual(lottoNumbers);

        //then
        assertThat(lottosByManual.size()).isEqualTo(2);
    }

    @Test
    public void 자동생성시_인자로_입력된_개수만큼_로또가_생성된다() {
        //given
        List<Lotto> autoLottos = LottoGameManager.getLottosByAuto(new RandomLottoGenerator(), 5);

        //when

        //then
        assertThat(autoLottos.size()).isEqualTo(5);
    }
}
