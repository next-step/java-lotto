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
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4,  5,  6)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4,  5,  7)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4,  5,  8)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4, 35, 37)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3, 34, 35, 37)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 6,  7,  8,  9, 10, 11)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3, 14, 15, 16)));
        lottoNumbers.add(LottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3, 24, 25, 26)));
    }

    @Test
    public void 당첨_통계_당첨존재() {
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.fromIntegers(Arrays.asList( 1,  2,  3,  4,  5,  6, 7));

        LottoNumberMatcher matcher = new LottoNumberMatcher(lottoNumbers, winningLottoNumbers);
        LottoWinningRecord record = matcher.result();

        assertThat(record.lottoRankMap().get(LottoRank.MATCH_3)).isEqualTo(3);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_4)).isEqualTo(1);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_5)).isEqualTo(1);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_5_AND_BONUS)).isEqualTo(1);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_6)).isEqualTo(1);

        int expected = LottoRank.MATCH_3.money() * 3
                + LottoRank.MATCH_4.money() * 1
                + LottoRank.MATCH_5.money() * 1
                + LottoRank.MATCH_5_AND_BONUS.money() * 1
                + LottoRank.MATCH_6.money() * 1;
        assertThat(record.totalLottoPrizeAmount()).isEqualTo(expected);
    }

    @Test
    public void 당첨_통계_당첨없을경우() {
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.fromIntegers(Arrays.asList(39, 40, 41, 42, 43, 44, 45));

        LottoNumberMatcher matcher = new LottoNumberMatcher(lottoNumbers, winningLottoNumbers);
        LottoWinningRecord record = matcher.result();

        assertThat(record.lottoRankMap().get(LottoRank.MATCH_3)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_4)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_5)).isEqualTo(0);
        assertThat(record.lottoRankMap().get(LottoRank.MATCH_6)).isEqualTo(0);
        assertThat(record.totalLottoPrizeAmount()).isEqualTo(0);
    }
}
