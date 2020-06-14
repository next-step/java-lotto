package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public List<Integer> lottoDrawNumbers = new ArrayList();
    public static final int LOTTO_PRICE = 1000;
    public static final int LIMIT = 6;
    private static final int MAX = 45;

    public Lotto() {
        for(int i = 1; i <= MAX; i++) {
            lottoDrawNumbers.add(i);
        }
    }

    public enum Rank {
        ALL_MATCH(1,6, 2000000000),
        MISS_ONE(2, 5, 1500000),
        MISS_TWO(3, 4, 50000),
        MISS_THREE(4, 3,5000),
//        NONE(5, 0, 0)
        ;

        private final int rank;
        private final int matchNumber;
        private final int prize;
        private int count;

        Rank(int rank, int matchNumber, int prize) {
            this.rank = rank;
            this.matchNumber = matchNumber;
            this.prize = prize;
        }

        public int getMatchNumber() {
            return matchNumber;
        }

        public int getPrize() {
            return prize;
        }

        public int getCount() {
            return count;
        }

        public void plusCount() {
            this.count++;
        }
    }
}
