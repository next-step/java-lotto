package domain

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class RankKtTest {

    @Test
    fun `맞춘개수 0개 금액 0원`() {
        val jackpot1 = RankKt.valueOf(1)
        assertThat(jackpot1.prizeMoney).isEqualTo(0)
    }

    @Test
    fun `맞춘개수 6개 금액 0원`() {
        val jackpot1 = RankKt.valueOf(6)
        assertThat(jackpot1.prizeMoney).isEqualTo(2000000000)
    }

    @Test
    fun `오등이 3번된 경우 금액 15000원`() {
        val totalPrize = RankKt.SAME_3_NUMBERS.getTotalPrizeMoney(3)
        assertThat(totalPrize).isEqualTo(15000)
    }
}
