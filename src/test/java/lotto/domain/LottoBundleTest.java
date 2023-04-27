package lotto.domain;

import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    @DisplayName("로또 레이팅 테스트")
    void rating() {
        final WinningBall winningBall = new WinningBall(new Lotto(new LottoNumbers("1,2,3,4,5,6")), new LottoNumber(7));
        final LottoBundle lottoBundle = new LottoBundle(List.of("1,2,3,4,5,6"), 0);

        assertThat(lottoBundle.rating(winningBall))
                .isInstanceOf(WinningStat.class);
    }
}
