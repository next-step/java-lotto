package domain

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class RankKtTest {

    @Test
    fun `맞춘개수 0개 금액 0원`() {
        val jackpot1 = RankKt.valueOf(0, false)
        assertThat(jackpot1.prizeMoney).isEqualTo(0)
    }

    @Test
    fun `맞춘개수 6개 1등금액`() {
        val rank = RankKt.valueOf(6, false)
        assertThat(rank.prizeMoney).isEqualTo(2000000000)
    }

    @Test
    fun `맞춘개수 5개 3등금액`() {
        val rank = RankKt.valueOf(5, false)
        assertThat(rank.prizeMoney).isEqualTo(1500000)
    }

    @Test
    fun `맞춘개수 5개 2등금액`() {
        val rank = RankKt.valueOf(5, true)
        assertThat(rank.prizeMoney).isEqualTo(30000000)
    }

    @Test
    fun `오등이 3번된 경우 금액 15000원`() {
        val totalPrize = RankKt.FIFTH.getTotalPrizeMoney(3)
        assertThat(totalPrize).isEqualTo(15000)
    }
}
