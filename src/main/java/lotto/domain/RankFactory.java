package lotto.domain;

public class RankFactory {

    public static Rankable rank(int matchCount) {
        if (matchCount == 6) {
            return new FirstClass();
        }

        if (matchCount == 5) {
            return new SecondClass();
        }

        if (matchCount == 4) {
            return new ThirdClass();
        }

        if (matchCount == 3) {
            return new FourthClass();
        }

        return Rankable.NONE;
    }
}
