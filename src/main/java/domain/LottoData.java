package domain;

import java.util.List;

public enum LottoData {
    FIRST_WINNER(2000000000, 6) {
        public long getCountWinner() {
            return countsOfWinningResultConvertList.stream().filter(x -> x.equals(match)).count();
        }
    },
    SECOND_WINNER(1500000, 5) {
        public long getCountWinner() {
            return countsOfWinningResultConvertList.stream().filter(x -> x.equals(match)).count();
        }
    },
    THIRD_WINNER(50000, 4) {
        public long getCountWinner() {
            return countsOfWinningResultConvertList.stream().filter(x -> x.equals(match)).count();
        }
    },
    FORTH_WINNER(5000, 3) {
        public long getCountWinner() {
            return countsOfWinningResultConvertList.stream().filter(x -> x.equals(match)).count();
        }
    },
    BOBUS_SECOND_WINNER(30000000, 5) {
        public long getCountWinner() {
            return bonusBallCount;
        }
    };

    int prize, match;
    static int bonusBallCount;
    private static List<Integer> countsOfWinningResultConvertList;

    private LottoData(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }

    public static void setBonusBallCount(int count) {
        bonusBallCount = count;
    }

    public static void setCountsOfWinningResultConvertList(List<Integer> result) {
        countsOfWinningResultConvertList = result;
    }

    public abstract long getCountWinner();
}

