package domain

import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class LottoStatisticsKtTest {

    private lateinit var lottoStatistics: LottoStatisticsKt

    @Before
    fun setup() {
        val winningNumbers = "1, 2, 3, 4, 5, 6"
        lottoStatistics = LottoStatisticsKt(winningNumbers)
    }

    @Test
    fun 당첨통계_0개일치_확인() {
        val lottoNumbers = lottoStatistics.getNumbers("8, 10, 20, 30 ,40, 45")
        val jackpot = lottoStatistics.getJackpot(lottoNumbers)
        assertThat(jackpot).isEqualTo(JackpotKt.SAME_0_NUMBERS)
    }

    @Test
    fun 당첨통계_3개일치_확인() {
        val lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 23, 35, 37")
        val jackpot = lottoStatistics.getJackpot(lottoNumbers)
        assertThat(jackpot).isEqualTo(JackpotKt.SAME_3_NUMBERS)
    }

    @Test
    fun 당첨통계_4개일치_확인() {
        val lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 4, 35, 37")
        val jackpot = lottoStatistics.getJackpot(lottoNumbers)
        assertThat(jackpot).isEqualTo(JackpotKt.SAME_4_NUMBERS)
    }

    @Test
    fun 당첨통계_5개일치_확인() {
        val lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 4, 5, 42")
        val jackpot = lottoStatistics.getJackpot(lottoNumbers)
        assertThat(jackpot).isEqualTo(JackpotKt.SAME_5_NUMBERS)
    }

    @Test
    fun 당첨통계_6개일치_확인() {
        val lottoNumbers = lottoStatistics.getNumbers("1, 2, 3, 4, 5, 6")
        val jackpot = lottoStatistics.getJackpot(lottoNumbers)
        assertThat(jackpot).isEqualTo(JackpotKt.SAME_6_NUMBERS)
    }
}
