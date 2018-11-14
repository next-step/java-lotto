package domain

import org.junit.Before
import org.junit.Test

import java.util.Arrays

import org.assertj.core.api.Assertions.assertThat

class LottoResultKtTest {

    private lateinit var lottoResult: LottoResultKt

    private val dummyRanks: List<RankKt>
        get() = Arrays.asList(
                RankKt.MISS,
                RankKt.MISS,
                RankKt.FIFTH,
                RankKt.MISS,
                RankKt.MISS
        )

    @Before
    fun setup() {
        lottoResult = LottoResultKt(dummyRanks)
    }

    @Test
    fun `번호 3개일치 항목 개수체크`() {
        val matchCount = lottoResult.matchCount(RankKt.FIFTH)
        assertThat(matchCount).isEqualTo(1)
    }

    @Test
    fun `번호 4개일치 항목 개수체크`() {
        val matchCount = lottoResult.matchCount(RankKt.FOURTH)
        assertThat(matchCount).isEqualTo(0)
    }

    @Test
    fun `번호 5개일치 항목 개수체크`() {
        val matchCount = lottoResult.matchCount(RankKt.THIRD)
        assertThat(matchCount).isEqualTo(0)
    }

    @Test
    fun `번호 6개일치 항목 개수체크`() {
        val matchCount = lottoResult.matchCount(RankKt.FIRST)
        assertThat(matchCount).isEqualTo(0)
    }

    @Test
    fun `수익률 구하기`() {
        val rate = lottoResult.calculatorRate()
        assertThat(rate).isEqualTo(1.0)
    }
}
