package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static domain.LottoGames.LOTTO_NUMBER;
import static domain.LottoGames.MIN_WINNER_NUMBER;
import static domain.NumberGenerator.FIRST_NUMBER;
import static domain.NumberGenerator.INT_ZERO;

public class WinnerNumberManager {

    private int[] winnerNumber;
    private int bonusNumber;
    private RankRecord rankRecord;

    public RankRecord getRankRecord() {
        return rankRecord;
    }

    public WinnerNumberManager(int[] number, int bonusNumber) {
        rankRecord = new RankRecord();
        this.winnerNumber = number;
        this.bonusNumber = bonusNumber;
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
        Lotto lotto = lottos.getOneLotto(i);
        int count = countNumber(lotto);
        int winnerPrice = 0;

        if (count == 5 && bonusNumber == getLastNumber(lotto)) {
            System.out.println("EE!!!!!!");
        }

        if (count >= MIN_WINNER_NUMBER) {
            winnerPrice = calculateWinnerRank(count);
        }
        return winnerPrice;
    }

    private int calculateWinnerRank(int count) {

        List<WinnerRanking> winrank = Arrays.stream(WinnerRanking.values())
                .filter(rank -> rank.getCount() == count)
                .collect(Collectors.toList());

        int price = winrank.get(INT_ZERO).getWinnerPrice();
        rankRecord.getRecordPool()[count]++;

        return price;
    }

    private int getLastNumber(Lotto lotto) {
        List<Integer> list = lotto.getLottoNumber();

        List<Integer> lastNumber = list.stream().filter(elm->list.contains(elm))
                .collect(Collectors.toList());

        for (int i = 0; i <list.size() ; i++) {
            System.out.println("last numb is = "+lastNumber.get(i));

        }

        return lastNumber.get(INT_ZERO);
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
