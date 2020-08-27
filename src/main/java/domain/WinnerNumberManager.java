package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.LottoGames.MIN_WINNER_NUMBER;
import static domain.NumberGenerator.INT_ZERO;

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
            sum += getSum(lottos, i);
        }
        System.out.println(sum);
        return sum;
    }

    private int getSum(Lottos lottos, int i) {
        int count = countNumber(lottos.getOneLotto(i), winnerNumber);
        int winnerPrice = 0;

        if (count >= MIN_WINNER_NUMBER) {
            winnerPrice = calculateWinnerPrice(count);
            rankRecord.recordRankings(count);
        }
        return winnerPrice;
    }

    private int countNumber(Lotto lotto, WinnerNumber winnerNumber) {
        return winnerNumber.getCountingNumber(lotto);
    }

    private int calculateWinnerPrice(int count) {

        List<WinnerRanking> winrank = Arrays.stream(WinnerRanking.values())
                .filter(rank -> rank.getCount() == count)
                .collect(Collectors.toList());

        int price = winrank.get(INT_ZERO).getWinnerPrice();

        return price;
    }
}
