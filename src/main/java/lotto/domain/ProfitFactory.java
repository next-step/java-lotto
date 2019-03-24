package lotto.domain;

public class ProfitFactory {

    public static Profitable profit(int rank) {
        if (rank == 6) {
            return new FirstRank();
        }

        if (rank == 5) {
            return new SecondRank();
        }

        if (rank == 4) {
            return new ThirdRank();
        }

        if (rank == 3) {
            return new FourthRank();
        }

        return Profitable.NONE;
    }
}
