package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @Test
    @DisplayName("1개의 5등 당첨 로또가 있기때문에 findWinningRanks를 할 경우 5등짜리 1개가 나온다.")
    void findWinningRankCont() {
        List<Lotto> lottos = Arrays.asList(new Lotto((Arrays.asList(1, 2, 3, 4, 5, 6))));
        Lotto winnigLotto = new Lotto((Arrays.asList(1, 2, 3, 10, 11, 12)));
        LottoNumber lottoNumber = new LottoNumber(7);

        this.lottoResult = new LottoResult(new WinningLotto(winnigLotto, lottoNumber));

        Map<Rank, Long> winningRanks = this.lottoResult.findWinningRankCont(lottos);

        assertThat(winningRanks).containsEntry(Rank.FIFTH, 1L);
    }
}