package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumbersMatcherTest {

    List<LottoNumbers> lottoNumbers = new ArrayList<>();

    @BeforeEach
    private void setUp() {
//        LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6))
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4,  5,  6)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 6,  7,  8,  9, 10, 11)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3, 14, 15, 16)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3, 24, 25, 26)));
    }

    @Test
    public void 당첨_통계_당첨존재() {
        LottoNumbers winningLottoNumbers = LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4,  5,  6));

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
        LottoNumbers winningLottoNumbers = LottoNumbers.fromIntegers(Arrays.asList(40, 41, 42, 43, 44, 45));

        LottoNumberMatcher matcher = new LottoNumberMatcher(lottoNumbers, winningLottoNumbers);
        LottoWinningRecord record = matcher.result();

        assertThat(record.lottoRankMap().get(LottoRank.MATCH_3)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_4)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_5)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_6)).isEqualTo(0);
        assertThat(record.totalLottoPrizeAmount()).isEqualTo(0);
    }
}
