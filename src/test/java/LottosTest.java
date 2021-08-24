import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    private WinningLotto winningLotto;

    private Lotto lotto;

    @Test
    @BeforeEach
    public void 로또만들기() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        lotto = new Lotto(() -> lottoNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(7);

        winningLotto = new WinningLotto(lotto, bonusLottoNumber);
    }

    @Test
    public void 당첨로또와동일한경우_1등당첨_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        lottos.makeWinningLottoResult(winningLotto);
        assertThat(lottos.getWinningStatistics().getWinningStatistic().get(LottoPrizeType.FIRST_PRIZE)).isEqualTo(1);
    }

}
