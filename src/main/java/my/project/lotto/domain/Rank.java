package my.project.lotto.domain;

/**
 * Created : 2020-11-27 오후 4:34
 * Developer : Seo
 */
public enum Rank {
    FIRST(1, 6, 0),
    THIRD(3, 5, 0),
    FOURTH(4, 4, 0),
    FIFTH(5, 3, 0),
    EMPTY(0, 0, 0);

    public static int rank(int bonusNo, Lotto lotto, int matchCount) {
        if (matchCount == 6) {
            return 1;
        }
        boolean matchBonus = lotto.contains(bonusNo);
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
    }
}
