package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberMatcherTest {

    List<LottoNumber> lottoNumbers = new ArrayList<>();

    @BeforeEach
    private void setUp() {
        lottoNumbers.add(new LottoNumber(Arrays.asList( 1,  2,  3,  4,  5,  6)));
        lottoNumbers.add(new LottoNumber(Arrays.asList( 6,  7,  8,  9, 10, 11)));
        lottoNumbers.add(new LottoNumber(Arrays.asList( 1,  2,  3, 14, 15, 16)));
        lottoNumbers.add(new LottoNumber(Arrays.asList( 1,  2,  3, 24, 25, 26)));
    }

    @Test
    public void 당첨_통계_당첨존재() {
        LottoNumber winningLottoNumbers = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoNumberMatcher matcher = new LottoNumberMatcher(lottoNumbers, winningLottoNumbers);
        LottoWinningRecord record = matcher.result();

        assertThat(record.lottoRankMap().get(LottoRank.MATCH_3)).isEqualTo(2);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_4)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_5)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_6)).isEqualTo(1);
        assertThat(record.totalLottoPrizeAmount()).isEqualTo(2_000_010_000);

    }

    @Test
    public void 당첨_통계_당첨없을경우() {
        LottoNumber winningLottoNumbers = new LottoNumber(Arrays.asList(40, 41, 42, 43, 44, 45));

        LottoNumberMatcher matcher = new LottoNumberMatcher(lottoNumbers, winningLottoNumbers);
        LottoWinningRecord record = matcher.result();

        assertThat(record.totalLottoPrizeAmount()).isEqualTo(0);
    }
}
