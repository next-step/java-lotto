package AutoLotto.domain.play;

import AutoLotto.domain.lotto.Lotto;
import AutoLotto.domain.lotto.LottoNum;
import AutoLotto.domain.lotto.Lottos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayLottoTest {

    @Test
    void canCountHitsForTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(), new Lotto()));
        List<LottoNum> buzzNumList = Arrays.asList(new LottoNum(45), new LottoNum(7), new LottoNum(3),
                new LottoNum(4), new LottoNum(17), new LottoNum(31));

        PlayLotto playLotto = new PlayLotto(lottos, buzzNumList);

        assertThat(playLotto.countHits()).hasSize(2);
        assertThat(playLotto.countHits().get(0)).isLessThanOrEqualTo(6);
    }
}
