package lotto;

import lotto.utils.GenerateLottoMachine;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoGameTest {

    @Test
    public void 기본금액이_1000원인_상태에서_구입금액을_0원으로_했을떄_로또가_발급되지_않으면_정상() {
        final LottoGame lottoGame = new LottoGame(0, 1000, new GenerateLottoMachine());
        assertThat(lottoGame.getLottos().size()).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 기본금액이_0원인_상태에서_구입금액을_10000원으로_했을떄_IllegalArgumentException_예외가_발생하면_정상() {
        new LottoGame(10000, 0, new GenerateLottoMachine());
    }

    @Test
    public void 기본금액이_1000원인_상태에서_입력한_금액만큼_로또가_발급되는지_확인() {
        final LottoGame lottoGame = new LottoGame(10000, 1000, new GenerateLottoMachine());
        assertThat(lottoGame.getLottos().size()).isEqualTo(10);
    }

    @Test
    public void 기본금액이_1200원인_상태에서_입력한_금액만큼_로또가_발급되는지_확인() {
        final LottoGame lottoGame = new LottoGame(10000, 1200, new GenerateLottoMachine());
        assertThat(lottoGame.getLottos().size()).isEqualTo(8);
    }

}