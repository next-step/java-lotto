package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class WinningNumbers {
    private static final int LOTTO_COST = 1000;
    List<Integer> winningLottoNumbers;
    Integer bonusNumber;
    List<Rank> rankList = new ArrayList<>();

    public WinningNumbers(List<Integer> winningLottoNumbers) {
        for (Integer winningNumber : winningLottoNumbers) {
            checkWinningNumbers(winningNumber);
        }
        this.winningLottoNumbers = winningLottoNumbers.subList(0, 6);
        this.bonusNumber = winningLottoNumbers.get(6);
    }

    private void checkWinningNumbers(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("당첨번호가 올바르지 않습니다.");
        }
    }

    public void winLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            sameNumberCount(lotto.getLottoNumber());
        }
    }

    private void sameNumberCount(List<Integer> lotto) {
        int count = (int) lotto
                .stream()
                .filter(o -> winningLottoNumbers.stream().anyMatch(Predicate.isEqual(o)))
                .count();

        if (count == 5) {
            rankList.add(Rank.valueOf(count, checkBonus(lotto)));
        }

        rankList.add(Rank.valueOf(count, checkBonus(lotto)));
    }

    //보너스 번호 체크
    private boolean checkBonus(List<Integer> lotto) {
        return lotto.contains(bonusNumber);
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
