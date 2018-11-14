package domain

enum class RankKt(val matchNumber: Int, var prizeMoney: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    fun getTotalPrizeMoney(sameCount: Int): Int {
        return this.prizeMoney * sameCount
    }

    fun isSameMatchNumber(matchNumber: Int): Boolean {
        return this.matchNumber == matchNumber
    }

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): RankKt {
            return RankKt.values()
                    .filter { it.isSameMatchNumber(matchCount) }
                    .firstOrNull { it != SECOND || matchBonus }
                    ?: MISS
        }
    }
}
