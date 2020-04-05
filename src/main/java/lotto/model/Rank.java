package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Rank {

//    FIRST(6, 2000000000),
//    SECOND(5, 1500000),
//    THIRD(4, 50000),
//    FOURTH(3, 5000),
//    ZERO(0, 0);


    private int matchCount;
    private int rank;
    private int prize;


    public Rank(int matchCount) {
        this.matchCount = matchCount;
        this.rank = calcRank(matchCount);
        this.prize = calcPrize(calcRank(matchCount));
    }


    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    int calcRank(int matchCount) {
        if (matchCount == 6) {
            return 1;
        } else if (matchCount == 5) {
            return 2;
        } else if (matchCount == 4) {
            return 3;
        } else if (matchCount == 3) {
            return 4;
        } else if (matchCount == 2) {
            return 5;
        }
        return 6;
    }
    int calcPrize(int rank) {
        if (rank == 1) {
            return 2000000000;
        } else if (rank == 2) {
            return  1500000;
        } else if (rank == 3) {
            return 50000;
        } else if (rank == 4){
            return 5000;
        }
        return 0;
    }


}
