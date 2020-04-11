package lotto.domain.rank;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("당첨 번호는 로또들을 입력하면 입력한 로또들에 대한 당첨 여부를 알 수 있다.")
    @Test
    public void matchLotteriesTest() {
        List<Integer> lottoNumbersOneToSix = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lotteries = Arrays.asList(Lotto.of(lottoNumbersOneToSix));
        WinningLotto winningLotto = new WinningLotto(Lotto.of(lottoNumbersOneToSix), LottoNumber.of(7));

        List<LottoRank> lottoRanks = winningLotto.matchLotteries(lotteries);
        LottoRank lottoRank = lottoRanks.get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(LottoRank.SIX.getMatchCount());
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.SIX.getWinningPrize());
    }

}
