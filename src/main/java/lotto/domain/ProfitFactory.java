package lotto.domain;

public class ProfitFactory {

    public static Profitable profit(int rank) {
        if (rank == 1) {
            return new FirstRank();
        }

        if (rank == 2) {
            return new SecondRank();
        }

        if (rank == 3) {
            return new ThirdRank();
        }

        if (rank == 4) {
            return new FourthRank();
        }

        return Profitable.NONE;
    }
}
