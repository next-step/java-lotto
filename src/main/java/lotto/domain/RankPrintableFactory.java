package lotto.domain;

public class RankPrintableFactory {
    static final int FIRST = 1;
    static final int SECOND = 2;
    static final int THIRD = 3;
    static final int FOURTH = 4;
    static final int FIFTH = 5;

    public static RankPrintable makeRanksForPrint(int rank) {
        if(rank == FIRST) {
            return new First();
        }

        if(rank == SECOND) {
            return new Second();
        }

        if(rank == THIRD) {
            return new Third();
        }

        if(rank == FOURTH) {
            return new Fourth();
        }

        if(rank == FIFTH) {
            return new Fifth();
        }

        return RankPrintable.NONE;
    }

}
