package AutoLotto.domain.play;

import AutoLotto.domain.lotto.BuzzLotto;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLottos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayLottoTest {

    @Test
    void canCountHitsForTest() {
        UserLottos userLottos = new UserLottos(Arrays.asList(new UserLotto(), new UserLotto()));
        BuzzLotto buzzLotto = new BuzzLotto(Arrays.asList(new LottoNumber(45), new LottoNumber(7), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(17), new LottoNumber(31)));

        PlayLotto playLotto = new PlayLotto(userLottos, buzzLotto);
//
//        assertThat(playLotto.countHits()).hasSize(2);
//        assertThat(playLotto.countHits().get(0)).isLessThanOrEqualTo(6);
    }
}
