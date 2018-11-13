package domain

import org.junit.Test

class LottoKtTest {

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun 로또_번호_갯수오류() {
        val lotto = LottoKt.manual("1, 2, 3, 4, 5")
    }

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun 로또_번호_갯수초과() {
        val lotto = LottoKt.manual("1, 2, 3, 4, 5, 6, 7")
    }

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun 로또_번호가_1보다_작을때_오류() {
        val lotto = LottoKt.manual("0, 2, 3, 4, 5, 6")
    }

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun 로또_번호가_45보다_클때_오류() {
        val lotto = LottoKt.manual("1, 2, 3, 100, 5, 6")
    }
}
