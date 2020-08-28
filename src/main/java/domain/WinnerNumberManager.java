package domain;

import java.util.Arrays;
import java.util.Optional;

import static domain.LottoGames.MIN_WINNER_NUMBER;

public class WinnerNumberManager {
    private WinnerNumber winnerNumber;
    private RankRecord rankRecord;

    public RankRecord getRankRecord() {
        return rankRecord;
    }

    public WinnerNumberManager(WinnerNumber number) {
        rankRecord = new RankRecord();
        this.winnerNumber = number;
    }

     public int calculateWinnerPrice(Lottos lottos) {
        int sum = 0;

        for (int i = 0; i < lottos.getNumOfLottos(); i++) {
            sum += sumAndRecord(lottos, i);
        }
        System.out.println(sum);
        return sum;
    }

    private int sumAndRecord(Lottos lottos, int i) {
        int count = countNumber(lottos.getOneLotto(i), winnerNumber);
        int winnerPrice = 0;

        if (count >= MIN_WINNER_NUMBER) {
            //getPrice
            winnerPrice = sumOfWinnerPrice(count);

            //Record
            rankRecord.recordOfRankings(count);
        }
        return winnerPrice;
    }

    private int countNumber(Lotto lotto, WinnerNumber winnerNumber) {
        return winnerNumber.getCountingNumber(lotto);
    }

    private int sumOfWinnerPrice(int count) {
        Optional<WinnerRanking> winRank = Arrays.stream(WinnerRanking.values())
                .filter(rank -> rank.getCount() == count).findFirst();

        return winRank.get().getWinnerPrice();
    }
}
