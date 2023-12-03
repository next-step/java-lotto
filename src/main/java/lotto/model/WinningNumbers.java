package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class WinningNumbers {
    private static final int LOTTO_COST = 1000;
    Lotto winningLottoNumbers;
    LottoNumber bonusNumber;
    List<Rank> rankList = new ArrayList<>();

    public WinningNumbers(String winningLottoNumbers, Integer bonusNumber) {
        this.winningLottoNumbers = new Lotto(winningLottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public void winLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            sameNumberCount(lotto);
        }
    }

    private void sameNumberCount(Lotto lotto) {
        long count = lotto.getLottoNumber()
                .stream()
                .filter(o -> winningLottoNumbers.getLottoNumber().stream().anyMatch(Predicate.isEqual(o)))
                .count();
        rankList.add(Rank.valueOf(count, containsBonus(count, lotto)));
    }

//    private void sameNumberCount(Lotto lotto) {
//        int count = (int) lotto
//                .stream()
//                .filter(o -> winningLottoNumbers.stream().map(LottoNumber::getLottoNumber).anyMatch(Predicate.isEqual(o)))
//                .count();
//        rankList.add(Rank.valueOf(count, containsBonus(count,lotto)));
//    }

    private boolean containsBonus(long count, Lotto lotto) {
        if (count == 5) {
            return lotto.getLottoNumber().contains(bonusNumber);
        }
        return false;
    }

    public Integer getWinnerNumber(Rank rank) {
        return Collections.frequency(rankList, rank);
    }

    public String getRate(Integer money) {
        double margin;
        int profit = 0;
        int primeCost = money * LOTTO_COST;
        for (Rank rank : rankList) {
            profit += rank.getWinningMoney();
        }
        margin = (double) profit / primeCost;
        return String.format("%.2f", margin);
    }
}
