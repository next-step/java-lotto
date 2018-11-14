package domain

import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class LottoStatisticsKtTest {

    private lateinit var lottoStatistics: LottoStatisticsKt

    @Before
    fun setup() {
        val winningNumbers = "1, 2, 3, 4, 5, 6"
        lottoStatistics = LottoStatisticsKt(winningNumbers, 17)
    }

    @Test
    fun 당첨통계_0개일치_확인() {
        val lottoNumbers = mutableListOf(LottoKt.manual("10, 11, 13, 23, 35, 37"))
        val matchCount = lottoStatistics.match(lottoNumbers).matchCount(RankKt.MISS)
        assertThat(matchCount).isEqualTo(1)
    }

    @Test
    fun 당첨통계_3개일치_확인() {
        val lottoNumbers = mutableListOf(LottoKt.manual("1, 2, 3, 23, 35, 37"))
        val matchCount = lottoStatistics.match(lottoNumbers).matchCount(RankKt.FIFTH)
        assertThat(matchCount).isEqualTo(1)
    }

    @Test
    fun 당첨통계_4개일치_확인() {
        val lottoNumbers = mutableListOf(LottoKt.manual("1, 2, 3, 4, 35, 37"))
        val matchCount = lottoStatistics.match(lottoNumbers).matchCount(RankKt.FOURTH)
        assertThat(matchCount).isEqualTo(1)
    }

    @Test
    fun 당첨통계_5개일치_확인() {
        val lottoNumbers = mutableListOf(LottoKt.manual("1, 2, 3, 4, 5, 42"))
        val matchCount = lottoStatistics.match(lottoNumbers).matchCount(RankKt.THIRD)
        assertThat(matchCount).isEqualTo(1)
    }

    @Test
    fun 당첨통계_6개일치_확인() {
        val lottoNumbers = mutableListOf(LottoKt.manual("1, 2, 3, 4, 5, 6"))
        val matchCount = lottoStatistics.match(lottoNumbers).matchCount(RankKt.FIRST)
        assertThat(matchCount).isEqualTo(1)
    }
}
