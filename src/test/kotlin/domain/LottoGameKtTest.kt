package domain

import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class LottoGameKtTest {

    private lateinit var lottoGame: LottoGameKt

    @Before
    fun setup() {
        lottoGame = LottoGameKt()
    }

    @Test
    fun `가격으로 개수구하기`() {
        lottoGame.buyLotto(14000)
        assertThat(lottoGame.getLottoCount()).isEqualTo(14)
    }
}
