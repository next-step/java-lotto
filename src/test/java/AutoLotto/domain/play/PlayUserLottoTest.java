package AutoLotto.domain.play;

import AutoLotto.domain.lotto.Lotto;
import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.Lottos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayLottoTest {

    @Test
    void canCountHitsForTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(), new Lotto()));
        List<LottoNumber> buzzNumList = Arrays.asList(new LottoNumber(45), new LottoNumber(7), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(17), new LottoNumber(31));

        PlayLotto playLotto = new PlayLotto(lottos, buzzNumList);

        assertThat(playLotto.countHits()).hasSize(2);
        assertThat(playLotto.countHits().get(0)).isLessThanOrEqualTo(6);
    }
}
