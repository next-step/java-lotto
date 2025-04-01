package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000) {
        @Override
        public void print(LottoStatics lottoStatics) {
            System.out.println(this.getCountOfMatch() + "개 일치"
                + "(" + this.getWinningMoney() + "원)-"
                + lottoStatics.getFirstCount() + "개");
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        public void print(LottoStatics lottoStatics) {
            System.out.println(this.getCountOfMatch() + "개 일치, 보너스 볼 일치"
                + "(" + this.getWinningMoney() + "원)-"
                + lottoStatics.getSecondCount() + "개");
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        public void print(LottoStatics lottoStatics) {
            System.out.println(this.getCountOfMatch() + "개 일치"
                + "(" + this.getWinningMoney() + "원)-"
                + lottoStatics.getThirdCount() + "개");
        }
    },
    FOURTH(4, 50_000) {
        @Override
        public void print(LottoStatics lottoStatics) {
            System.out.println(this.getCountOfMatch() + "개 일치"
                + "(" + this.getWinningMoney() + "원)-"
                + lottoStatics.getFourthCount() + "개");
        }
    },
    FIFTH(3, 5_000) {
        @Override
        public void print(LottoStatics lottoStatics) {
            System.out.println(this.getCountOfMatch() + "개 일치"
                + "(" + this.getWinningMoney() + "원)-"
                + lottoStatics.getFifthCount() + "개");
        }
    },
    MISS(0, 0) {
        @Override
        public void print(LottoStatics lottoStatics) {
        }
    };

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 3) {
            return MISS;
        }

        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
            .filter(rank -> rank.countOfMatch == countOfMatch)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("countOfMatch가 잘못되었습니다. countOfMatch : " + countOfMatch));
    }

    private void printDefault(LottoStatics lottoStatics) {

    }

    public abstract void print(LottoStatics lottoStatics);
}
