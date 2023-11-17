package lotto.model;

import java.util.*;
import java.util.function.Predicate;

public class WinningNumbers {
    private static int LOTTO_COST = 1000;
    private static int MINIMUM_RANK=3;
    private static int MAXIMUM_RANK=6;
    List<Integer> winningLottoNumbers;
    List<Integer> sameNumberCount = new ArrayList<>();
    List<Integer> rankList = new ArrayList<>();
    Map<Integer,Integer> winnerMoney = new HashMap<>();
    public WinningNumbers(String input) {
        this.winningLottoNumbers = convertList(splitLottoNumbers(input));
        setWinnerMoney();
    }

    private void setWinnerMoney() {
        winnerMoney.put(3, 5_000);
        winnerMoney.put(4, 50_000);
        winnerMoney.put(5, 1_500_000);
        winnerMoney.put(6, 2_000_000_000);
    }

    private String[] splitLottoNumbers(String input) {
        return input.split(",");
    }

    private List<Integer> convertList(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            numbers.add(Integer.parseInt(winningNumber));
        }
        return numbers;
    }

    public void winLotto(List<Lotto> lottoList) {
        for (Lotto lotto:lottoList) {
            sameNumberCount(lotto.getLottoNumber());
        }
        rankList();
    }

    private void sameNumberCount(List<Integer> lotto) {
        int count = (int) lotto
                .stream()
                .filter(o -> winningLottoNumbers.stream().anyMatch(Predicate.isEqual(o)))
                .count();

        sameNumberCount.add(count);
    }

    private void rankList() {
        for (int i=0; i <= 6; i++) {
            rankList.add(Collections.frequency(sameNumberCount, i));
        }
    }

    public Integer getWinnerNumber(int rank) {
        return rankList.get(rank);
    }

    public Integer getWinnerPrice(int rank) {
        return winnerMoney.get(rank);
    }

    public String getRate(Integer money) {
        double margin;
        int profit = 0;
        int primeCost = money * LOTTO_COST;
        for (int i=MINIMUM_RANK; i<=MAXIMUM_RANK; i++) {
            profit += winnerMoney.get(i) * rankList.get(i);
        }
        margin = (double) profit/primeCost;

        return String.format("%.2f", margin);
    }
}
