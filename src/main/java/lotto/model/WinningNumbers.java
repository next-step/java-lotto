package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class WinningNumbers {
    private static final int LOTTO_COST = 1000;
    List<LottoNumber> winningLottoNumbers;
    LottoNumber bonusNumber;
    List<Rank> rankList = new ArrayList<>();

    public WinningNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = new ArrayList<>();
        for (Integer winningNumber : winningLottoNumbers.subList(0,6)) {
            this.winningLottoNumbers.add(new LottoNumber(winningNumber));
        }
        this.bonusNumber = new LottoNumber(winningLottoNumbers.get(6));
    }

    public void winLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            sameNumberCount(lotto.getLottoNumber());
        }
    }

    private void sameNumberCount(List<Integer> lotto) {
        int count = (int) lotto
                .stream()
                .filter(o -> winningLottoNumbers.stream().map(LottoNumber::getLottoNumber).anyMatch(Predicate.isEqual(o)))
                .count();
        rankList.add(Rank.valueOf(count, containsBonus(count,lotto)));
    }

    private boolean containsBonus(Integer count, List<Integer> lotto) {
        if (count == 5){
            return lotto.contains(bonusNumber.getLottoNumber());
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
