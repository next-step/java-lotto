package domain

enum class JackpotKt(val matchNumber: Int, var prizeMoney: Int) {
    SAME_0_NUMBERS(0, 0),
    SAME_1_NUMBERS(1, 0),
    SAME_2_NUMBERS(2, 0),
    SAME_3_NUMBERS(3, 5000),
    SAME_4_NUMBERS(4, 50000),
    SAME_5_NUMBERS(5, 1500000),
    SAME_6_NUMBERS(6, 2000000000);

    fun getTotalPrizeMoney(sameCount: Int): Int {
        return this.prizeMoney * sameCount
    }

    fun isSameMatchNumber(matchNumber: Int): Boolean {
        return this.matchNumber == matchNumber
    }

    companion object {
        fun valueOf(matchCount: Int): JackpotKt {
            return JackpotKt.values()
                    .firstOrNull { it.isSameMatchNumber(matchCount) }
                    ?: throw IllegalArgumentException("잘못된 데이터가 입력되었습니다.")
        }
    }
}
