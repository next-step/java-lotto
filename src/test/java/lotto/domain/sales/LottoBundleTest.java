package lotto.domain.sales;

import lotto.constant.LottoPrize;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.prize.WinningPrize;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    Lotto winningLotto = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::of).collect(Collectors.toList()));

    @Test
    void 개수만큼_로또_생성() {
        LottoBundle lottoBundle = LottoBundle.of(5);

        assertThat(lottoBundle.count()).isEqualTo(5);
    }

    @Test
    void 당첨_상금_조회() {
        LottoBundle lottoBundle = LottoBundle.of(List.of(
                Lotto.of("1,2,3,4,5,6"),
                Lotto.of("1,2,3,4,5,7"),
                Lotto.of("1,2,3,4,7,8"),
                Lotto.of("1,2,3,7,8,9"),
                Lotto.of("1,22,23,24,25,26"),
                Lotto.of("21,22,23,24,25,26")));

        WinningPrize winningPrize = lottoBundle.winPrize(winningLotto);

        assertThat(winningPrize.winAmount(LottoPrize.FOURTH.getMatch())).isEqualTo(1);
        assertThat(winningPrize.winAmount(LottoPrize.THIRD.getMatch())).isEqualTo(1);
        assertThat(winningPrize.winAmount(LottoPrize.SECOND.getMatch())).isEqualTo(1);
        assertThat(winningPrize.winAmount(LottoPrize.FIRST.getMatch())).isEqualTo(1);
    }
}
