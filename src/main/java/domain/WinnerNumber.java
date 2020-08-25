package domain;

import static domain.LottoGames.LOTTO_NUMBER;
import static domain.LottoGames.MIN_WINNER_NUMBER;
import static domain.NumberGenerator.FIRST_NUMBER;
import static domain.NumberGenerator.INT_ZERO;

public class WinnerNumber {
    public static final int RECORD_SIZE = 7;
    private int[] winnerNumber;
    private int[] rankRecord;

    public WinnerNumber(int[] number) {
        rankRecord = new int[RECORD_SIZE];
        this.winnerNumber = number;
    }

    public int[] getRankRecord() {
        return rankRecord;
    }

    public int[] getWinnerNumber() {
        return winnerNumber;
    }

    public int calculateCount(int tries, Lottos lottos) {
        int sum = 0;

        for (int i = 0; i < tries; i++) {
            sum += getSum(lottos, i);
        }
        System.out.println(sum);
        return sum;
    }

    private int getSum(Lottos lottos, int i) {
        int count = countNumber(lottos.getOneLotto(i));
        int winnerPrice = 0;

        if (count >= MIN_WINNER_NUMBER) {
            winnerPrice = calculateWinnerRank(count);
        }
        return winnerPrice;
    }

    public int calculateWinnerRank(int count) {
        int price = 0;

        for (WinnerRanking rank : WinnerRanking.values()) {
            if (rank.getCount() == count) {
                rankRecord[count]++;
                price = rank.getWinnerPrice();
            }
        }

        return price;
    }

    private int countNumber(Lotto lotto) {
        int count = 0;
        for (int j = 0; j < LOTTO_NUMBER; j++) {
            count += getHowManyCorrectCount(lotto, j);
        }
        return count;
    }

    private int getHowManyCorrectCount(Lotto lotto, int j) {
        if (lotto.getLottoNumber().contains((getWinnerNumber()[j]))) {
            return FIRST_NUMBER;
        }
        return INT_ZERO;
    }
}
