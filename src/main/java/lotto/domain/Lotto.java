package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final int purchasePrice;
    private final int purchaseAmount;

    public Lotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchasePrice = 1000;
    }

    public int purchase() {
        return this.purchaseAmount / this.purchasePrice;
    }

    public List<Integer> getLottoNumber(String winningLottoNumbers) {
        return winningNumber(winningLottoNumbers);
    }

    public List<Integer> getLottoNumber() {
        List<Integer> initialNumbers = generateInitialLottoNumber();
        return getWinningNumbers(initialNumbers);
    }

    private static List<Integer> getWinningNumbers(List<Integer> initialNumbers) {
        Collections.shuffle(initialNumbers);
        List<Integer> winningNumbers = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            winningNumbers.add(initialNumbers.get(i));
        }
        return winningNumbers;
    }

    public List<List<Integer>> chooseLottoNumber(int purchaseCount) {
        List<Integer> initialLottoNumbers = generateInitialLottoNumber();
        return shuffleLottoNumber(initialLottoNumbers, purchaseCount);
    }

    private List<List<Integer>> shuffleLottoNumber(List<Integer> initialLottoNumbers, int purchaseCount) {

        List<List<Integer>> purcahsedLottoList = new ArrayList<>();

        for(int i = 0; i < purchaseCount; i++) {
            purcahsedLottoList.add(getWinningNumbers(initialLottoNumbers));
        }
        return purcahsedLottoList;
    }

    public List<Integer> generateInitialLottoNumber() {
        List<Integer> initialLottoNumbers = new ArrayList<>();
        for(int i =1; i <= 45; i++) {
            initialLottoNumbers.add(i);
        }
        return initialLottoNumbers;
    }

    public List<Integer> winningNumber(String winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return purchaseAmount == lotto.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(purchaseAmount);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "purchasePrice=" + purchasePrice +
                ", purchaseAmount=" + purchaseAmount +
                '}';
    }


}
